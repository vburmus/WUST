public class Main {

    public static void main (String [] args) {
        final int countOfProc = 70;
        final int max =97;
        final int tries = 10;
        final int min = 3;
        final int countOfTasks = 200000;
        final int load = 15;
        Algorithms alg = new Algorithms(countOfProc, max, tries, min, countOfTasks, load);

        System.out.println("Wyniki:"+ "\n__________________________"+"\n Ilosc procesorow - "  + alg.getCountOfProc() + "\n Max obciazenie - "
                + alg.getMax()  + "\n Sprob oddac zadanie - " + alg.getTries() + "\n Min obciazenie - "
                + alg.getMin() + "\n Ilosc zadan - " + alg.getTasks().size() + "\n__________________________");
        alg.run();
    }
}
