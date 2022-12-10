public class Main {

    public static final int N = 5000;

    public static void main (String [] args) throws InterruptedException {
        Algorytmy alg = new Algorytmy(N);
        alg.ShellSort1();
        alg.ShellSort2();
        alg.ShellSort3();
        alg.wyswietl(N);
    }
}
