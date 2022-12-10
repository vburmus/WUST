public class InstrumentDety extends Instrument {
    private int lt;

    public InstrumentDety() {
        lt = 1;
        nazwa = "ZłotaTrabka";
    }
    public InstrumentDety(String nazwa, int a){
        super(nazwa);
        this.lt = a;
    }

    public int getLt() {
        return lt;
    }

    public void setLt(int lt) {
        this.lt = lt;
    }

    public String wydajDzwiek(){
        return "Tra ta ta";
    }
    public void graj(){
        for(int i = 0; i < lt; i++)
            System.out.println(wydajDzwiek());
    }
    public String toString() {
        return "Instrument dety: " + getNazwa() + " [lt = " + this.lt + "].";
    }
}
