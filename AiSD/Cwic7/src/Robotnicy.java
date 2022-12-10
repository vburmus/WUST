public class Robotnicy extends Pracownik {
    private double liczbaGodzin;
    private double stawka;
    private double limit;

    public Robotnicy() {
        nazwisko = "Chlen";
        etat = 1;
        liczbaGodzin = 10;
        stawka = 10;
        limit = 20;
    }

    public Robotnicy(String nazwisko, double etat, double liczbaGodzin, double stawka) {
        super(nazwisko, etat);
        this.liczbaGodzin = liczbaGodzin;
        this.stawka = stawka;
        this.limit = 10;
    }

    public double getLiczbaGodzin() {
        return liczbaGodzin;
    }

    public double getLimit() {
        return limit;
    }

    public double getStawka() {
        return stawka;
    }

    public void setLiczbaGodzin(double liczbaGodzin) {
        this.liczbaGodzin = liczbaGodzin;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public void setStawka(double stawka) {
        this.stawka = stawka;
    }


    public String toString() {
        return liczbaGodzin + " " + stawka + " " + limit + " ";
    }

    public boolean equals(Object o) {
        if (this == null) {
            return false;
        } else if (o instanceof Robotnicy) {
            Robotnicy o1 = (Robotnicy) o;
            return (getStawka() == o1.getStawka() && getLiczbaGodzin() == o1.getLiczbaGodzin());
        } else
            return false;
    }

    public double wyplata() {
        double wyplata = 0;
        if (getLiczbaGodzin() > getLimit()) {
            wyplata = (getLimit() * getStawka() + (getLiczbaGodzin() - getLimit()) * getStawka() * 1.5);
        } else
            wyplata = getLiczbaGodzin() * getStawka();
        return wyplata;
    }




}

