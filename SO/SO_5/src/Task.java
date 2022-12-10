import java.util.Random;

public class Task {

    int processorUsage;
    int compTime;

    public Task(int maxLoad) {
        Random generator = new Random();
        this.processorUsage = generator.nextInt(maxLoad-1) + 1;
        this.compTime = generator.nextInt(80) + 200;
    }

    public Task(Task task) {
        this.processorUsage = task.getProcessorUsage();
        this.compTime = task.getCompTime();
    }

    public int getCompTime() {
        return compTime;
    }

    public int getProcessorUsage() {
        return processorUsage;
    }

    public void setProcessorUsage(int processorUsage) {
        this.processorUsage = processorUsage;
    }

    public String toString() {
        return("Udział: " + processorUsage + "%" + "\t" + "Czas wykonania: " + compTime + " ms");
    }

    public void doTask()
    {
        this.compTime = this.compTime -1;
    }

    public boolean isDone()
    {
        return this.compTime <=0;
    }

    public void increaseTimeDecreaseLoad(int reminder) {
        this.compTime = this.compTime * (this.processorUsage /reminder);
        this.processorUsage = reminder;
    }
    public void decrease(int sub){
        this.compTime = this.compTime - sub;
    }
}
