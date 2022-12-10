public class InstrumentSmyczkowy extends Instrument {
    private int ls;

    public InstrumentSmyczkowy(){
        nazwa = "Stradivarus";
        ls = 1;
    }
    public InstrumentSmyczkowy(String nazwa, int a){
        super(nazwa);
        this.ls = a;
    }

    public int getLs() {
        return ls;
    }

    public void setLs(int ls) {
        this.ls = ls;
    }

    public String wydajDzwiek(){
        return "Smyk smyk smyk";
    }
    public void graj(){
        for(int i = 0;i < ls; i++)
            System.out.println(wydajDzwiek());
    }
    public String toString() {
        return "Instrument smyczkowy: " + getNazwa() + " [ls = "+ ls + "].";

    }
    public boolean jestKontrabasem(){
        if(getNazwa() == "kontrabas") return true;
        return false;
    }
}
