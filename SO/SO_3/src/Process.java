import java.util.ArrayList;

public class Process {

    private ArrayList<Strona> kolejkaOdwolan = new ArrayList<>();
    private int processId;
    private int avaliableFrames;
    private int countOfCalls;
    private  int sysRamki;

    public Process(int _id,int countOfCalls,int iloscSysSton,int zakres,int bound){
        this.countOfCalls = countOfCalls;
        KolejkaOdwolan kolejka = new KolejkaOdwolan(iloscSysSton);
        this.processId = _id;
        kolejka.wypelnij(zakres,countOfCalls,bound,iloscSysSton);
        this.kolejkaOdwolan = kolejka.getListaOdwolan();
        this.avaliableFrames = 0;
        this.sysRamki = kolejka.getIloscSysStron();
    }



    public ArrayList<Strona> getKolejkaOdwolan() {
        return kolejkaOdwolan;
    }

    public int getProcessId() {
        return processId;
    }

    public int getAvaliableFrames() {
        return avaliableFrames;
    }

    public int getCountOfCalls() {
        return countOfCalls;
    }

    public void setAvaliableFrames(int avaliableFrames) {
        this.avaliableFrames = avaliableFrames;
    }

    public int getSysRamki() {
        return sysRamki;
    }
}
