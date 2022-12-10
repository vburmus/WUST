public abstract class Pracownik {
    protected String nazwisko;
    protected double etat;

    public Pracownik(){
        nazwisko = "Duda";
        etat = 1;
    }
    public Pracownik(String nazwisko, double etat){
        this.nazwisko = nazwisko;
        this.etat = etat;
    }
    public String getNazwisko() {
        return nazwisko;
    }

    public double getEtat() {
        return etat;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setEtat(double etat) {
        this.etat = etat;
    }

    public String toString() {
        return  nazwisko + " " + etat + " ";
    }

    public boolean equals(Pracownik o){
        if(this == null){
            return false;
        }else if(o instanceof Pracownik){
            Pracownik o1 = (Pracownik) o;
            return (getEtat()==o1.getEtat() && getNazwisko()==getNazwisko());
        }else
            return false;
    }
    abstract public double wyplata();





    }




