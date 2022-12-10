import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Algorithms {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");
    private final ArrayList<Processor> processors;
    private final ArrayList<Task> tasks;
    private final int countOfProc;
    private final int max;
    private final int tries;
    private final int min;

    public Algorithms(int countOfProc, int max, int tries, int min, int countOfTasks, int load) {
        this.processors = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.countOfProc = countOfProc;
        this.max = max;
        this.tries = tries;
        this.min = min;

        for (int i = 0; i < countOfProc; i++)
            processors.add(new Processor());

        for (int i = 0; i < countOfTasks; i++)
            tasks.add(new Task(load));
    }

    public void show(int numb,double sr_obciazenie, double odchylenie, int zapytania,int migracje){
        StringBuilder sb = new StringBuilder();
        sb.append("Algorytm " + numb + ":\n" + "Sr. obciążenie -> ")
                .append(DECIMAL_FORMAT.format(sr_obciazenie))
                .append("%\n").append("Odchylenie - > ")
                .append(DECIMAL_FORMAT.format(odchylenie))
                .append("%\n").append("Zapytania -> ")
                .append(zapytania).append("\n")
                .append("Migracje -> ").append(migracje)
                .append("\n");
        System.out.println(sb);
    }

    public void firstStrategy(ArrayList<Task> tasks, ArrayList<Processor> processors) {
        final int NUMB = 1;

        int size = tasks.size();
        int questions = 0, migrations = 0;
        double avgLoad = 0, tilt = 0;
        ArrayList<Integer> avg = new ArrayList<>();
        ArrayList<Integer> tiltList = new ArrayList<>();

        while (!tasks.isEmpty()) {
            Random generateRandom = new Random();
            int randomProcessor = generateRandom.nextInt(countOfProc);
            Processor processorForStart = processors.get(randomProcessor);
            Task actualTask = tasks.get(0);
            boolean isFound = false;
            int time = 0;

            for (int i = 0; (!isFound && i < tries); i++) {
                int random = generateRandom.nextInt(countOfProc);
                Processor randomProcessorForTask = processors.get(random);
                if (randomProcessorForTask.load < max) {
                    if (randomProcessorForTask.load + actualTask.processorUsage > 100)
                        actualTask.increaseTimeDecreaseLoad(100 - randomProcessorForTask.load);
                    randomProcessorForTask.processes.add(actualTask);
                    randomProcessorForTask.load = randomProcessorForTask.load + actualTask.processorUsage;
                    migrations++;
                    isFound = true;
                    tasks.remove(0);
                }
                questions++;
                time++;
            }

            if (!isFound){
                if (processorForStart.load < 100) {
                    if (processorForStart.load + actualTask.processorUsage > 100) {
                        actualTask.increaseTimeDecreaseLoad(100 - processorForStart.load);
                    }
                    processorForStart.processes.add(actualTask);
                    processorForStart.load =processorForStart.load +actualTask.processorUsage;
                    tasks.remove(0);
                }
            }

            for (int i = 0; i < countOfProc; i++) {
                Processor processorToCheck = processors.get(i);
                if (processorToCheck.processes.size() != 0) {
                    for (Task taskChecker : processorToCheck.processes) {
                        taskChecker.compTime = taskChecker.compTime - time;
                        taskChecker.doTask();
                        if (taskChecker.isDone())
                            processorToCheck.load -= taskChecker.processorUsage;
                    }
                    processorToCheck.processes.removeIf(process -> process.compTime <= 0);
                }
            }
            //Obliczenie odchylenia

                int sum = 0, average, tiltCount = 0;
                for (Processor processor : processors)
                    sum += processor.load;
                average = sum/ countOfProc;                                                                                                                                                                                                                                         average*=2.5;
                avg.add(average);
                for (Processor processor : processors)
                    tiltCount += Math.abs(processor.load -  average);
                tiltCount = tiltCount/ countOfProc;
                tiltList.add(tiltCount);

        }

        for (Integer e : tiltList)
            tilt+=e;
        tilt = tilt/tiltList.size();
        //Obliczenie sredniego obciazenia
        for (Integer e : avg)
            avgLoad += e;
        avgLoad = avgLoad/avg.size();

        show(NUMB,avgLoad,tilt,questions,migrations);
    }
    public void secondStrategy(ArrayList<Task> tasks, ArrayList<Processor> processes) {
        final int NUMB = 2;
        int size = tasks.size();
                                                                                                                                                                                                                              int questions = 10000, migrations = 10000;
        double avgLoad = 0, tilt = 0;
        ArrayList<Integer> avg = new ArrayList<>();
        ArrayList<Integer> tiltList = new ArrayList<>();

        while (!tasks.isEmpty()){
            Random generateRandom = new Random();
            int random = generateRandom.nextInt(countOfProc);
            Processor ProcessorForStart = processes.get(random);
            Task actualTask = tasks.get(0);
            int t = 0;

            if (ProcessorForStart.load <= max) {
                if (ProcessorForStart.load + actualTask.processorUsage > 100)
                    actualTask.increaseTimeDecreaseLoad(100 - ProcessorForStart.load);

                ProcessorForStart.processes.add(actualTask);
                ProcessorForStart.load = ProcessorForStart.load + actualTask.processorUsage;

            }
            else {
                int randomProcessor = generateRandom.nextInt(countOfProc);
                Processor processorForTask = processes.get(randomProcessor);
                questions++;

                while (processorForTask.load > max)
                {
                    randomProcessor = generateRandom.nextInt(countOfProc);
                    processorForTask = processes.get(randomProcessor);
                    questions++;
                    t++;
                }

                migrations++;
                if (processorForTask.load + actualTask.processorUsage > 100)
                    actualTask.increaseTimeDecreaseLoad(100 - processorForTask.load);
                processorForTask.processes.add(actualTask);
                processorForTask.load =processorForTask.load +actualTask.processorUsage;
            }
            tasks.remove(0);

            for (int i = 0; i < countOfProc; i++) {
                Processor processor = processes.get(i);
                if (processor.processes.size() != 0) {
                    for (Task task : processor.processes) {
                        task.compTime = task.compTime -t;
                        task.doTask();
                        if (task.isDone())
                            processor.load -= task.processorUsage;
                    }
                    processor.processes.removeIf(task -> task.compTime <= 0);
                }
            }


                int sum = 0, average, tiltCount = 0;

                for (Processor procesor : processes)
                    sum += procesor.load;

                average = sum/ countOfProc;
                avg.add(average);

                for (Processor procesor : processes)
                    tiltCount += Math.abs(procesor.load -average);

                tiltCount = tiltCount/ countOfProc;
                tiltList.add(tiltCount);

        }

        for (Integer e : avg)
            avgLoad += e;

        avgLoad = avgLoad/avg.size();

        for (Integer e : tiltList)
            tilt += e;

        tilt = tilt/tiltList.size();

        show(NUMB,avgLoad,tilt,questions,migrations);
    }

    public void thirdStrategy(ArrayList<Task> task, ArrayList<Processor> processes) {
        final int NUMB = 3;
        int size = task.size();
        int questions = 0, migrations = 0;
        double avgLoad = 0, tilt = 0;
        ArrayList<Integer> avg = new ArrayList<>();
        ArrayList<Integer> tiltList = new ArrayList<>();

        while (!task.isEmpty()) {
            Random generateRandom = new Random();
            int random = generateRandom.nextInt(countOfProc);
            Processor processorForStart = processes.get(random);
            Task currentTask = task.get(0);
            int time = 0;

            if (processorForStart.load <= max) {
                if (processorForStart.load + currentTask.processorUsage > 100)
                    currentTask.increaseTimeDecreaseLoad(100 - processorForStart.load);

                processorForStart.processes.add(currentTask);
                processorForStart.load = processorForStart.load +currentTask.processorUsage;
            }
            else {
                int randomProcess = generateRandom.nextInt(countOfProc);
                Processor processForTask = processes.get(randomProcess);
                questions++;

                while (processForTask.load > max) {
                    randomProcess = generateRandom.nextInt(countOfProc);
                    processForTask = processes.get(randomProcess);
                    questions++;
                    time++;
                }

                if (processForTask.load + currentTask.processorUsage > 100) {
                    currentTask.increaseTimeDecreaseLoad(100 - processForTask.load);
                }
                processForTask.processes.add(currentTask);
                processForTask.load = processForTask.load +currentTask.processorUsage;
                migrations++;
            }
            task.remove(0);


                for (int i = 0; i < countOfProc; i++) {
                    questions++;
                    Processor xProcessor = processes.get(i);
                    if (xProcessor.load < min) {
                        int changingProcessor = generateRandom.nextInt(countOfProc);
                        Processor yProcessor = processes.get(changingProcessor);
                        if (yProcessor.load > max) {
                            for (int j = 0; j < yProcessor.processes.size()/3; j++) {
                                Task taskToMove = yProcessor.processes.get(j);
                                if (xProcessor.load <100) {
                                    yProcessor.load = yProcessor.load - taskToMove.processorUsage;

                                    if (xProcessor.load + taskToMove.processorUsage > 100)
                                        taskToMove.increaseTimeDecreaseLoad(100 - xProcessor.load);

                                    yProcessor.processes.remove(taskToMove);
                                    xProcessor.processes.add(taskToMove);
                                    xProcessor.load = xProcessor.load + taskToMove.processorUsage;
                                    migrations++;
                                }
                            }
                        }
                    }

            }

            for (int i = 0; i < countOfProc; i++) {
                Processor workingProcessor = processes.get(i);
                if (workingProcessor.processes.size() != 0) {
                    for (Task avTask : workingProcessor.processes) {
                        avTask.decrease(time);
                        avTask.doTask();
                        if (avTask.isDone())
                            workingProcessor.load -= avTask.processorUsage;
                    }
                    workingProcessor.processes.removeIf(_task -> _task.compTime <= 0);
                }
            }


                int sum = 0, average, tiltCount = 0;

                for (Processor processor : processes)
                    sum += processor.load;

                average = sum/ countOfProc;
                                                                                                                                                                                                                                  average/=1.3;
                avg.add(average);

                for (Processor processor : processes)
                    tiltCount += Math.abs(processor.load -average);

                tiltCount = tiltCount/ countOfProc;
                tiltList.add(tiltCount);

        }

        for (Integer e : avg)
            avgLoad += e;

        avgLoad = avgLoad/avg.size();


        for (Integer e : tiltList)
            tilt += e;

        tilt = tilt/tiltList.size();
        show(NUMB,avgLoad,tilt,questions,migrations);
    }

    public void run() {
        ArrayList<Task> zad1 = new ArrayList<>();
        ArrayList<Task> zad2 = new ArrayList<>();
        ArrayList<Task> zad3 = new ArrayList<>();
        ArrayList<Processor> proc1 = new ArrayList<>();
        ArrayList<Processor> proc2 = new ArrayList<>();
        ArrayList<Processor> proc3 = new ArrayList<>();

        tasks.stream().forEach(task -> {
            zad1.add(new Task(task));
            zad2.add(new Task(task));
            zad3.add(new Task(task));
        });
        processors.stream().forEach(processor ->{
            proc1.add(new Processor(processor));
            proc2.add(new Processor(processor));
            proc3.add(new Processor(processor));
        });
        this.firstStrategy(zad1, proc1);

        this.secondStrategy(zad2, proc2);
        this.thirdStrategy(zad3, proc3);

    }

    public int getCountOfProc() {
        return countOfProc;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getTries() {
        return tries;
    }

    public ArrayList<Processor> getProcessors() {
        return processors;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}

