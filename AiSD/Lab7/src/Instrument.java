public abstract class Instrument {

    protected String nazwa;

    public Instrument(){
        nazwa = "";
    }
    public Instrument(String nazwa){
        this.nazwa=nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String toString(){
        return  "Instrument o nazwie: ";
    }
    abstract public String wydajDzwiek();

    abstract public void graj();
}
