import java.util.ArrayList;

public class Main {

    public static final int ILOSC_SYS_STRON = 10000;
    public static final int NUM_OF_FRAMES = 30;

    public static void main(String[] args) {

        Algorytmy alg = new Algorytmy();
        KolejkaOdwolan kolejkaOdwolan = new KolejkaOdwolan(ILOSC_SYS_STRON);
        ArrayList<Process> list = kolejkaOdwolan.makeListOfProcesses(10,140,100, 500);

        alg.PR(NUM_OF_FRAMES,list);
        alg.PP(NUM_OF_FRAMES,list);
        alg.SCBS(NUM_OF_FRAMES,list,10,200,100,400);
        alg.PS(NUM_OF_FRAMES,list,10,200);

    }

}
