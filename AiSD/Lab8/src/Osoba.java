public abstract class Osoba {
    protected String nazwisko;
    protected String pesel;
    public Osoba(){
        nazwisko = "";
        pesel = "";
    }
    public Osoba(String nazwisko,String pesel){
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String toString() {
        return nazwisko + " " + pesel;
    }
    public abstract double oblicz();
}
