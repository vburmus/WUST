public class Urzednicy extends Pracownik {
    private double placaPodstawowa;
    private double premia;
    public Urzednicy(String nazwisko,double placaPodstawowa, double etat, double premia){
        super(nazwisko, etat);
        this.placaPodstawowa = placaPodstawowa;
        this.premia = premia;
    }
    public Urzednicy(){
        nazwisko = "Duda";
        etat = 1;
        placaPodstawowa = 1300;
        premia = 10;
    }

    public double getPlacaPodstawowa() {
        return placaPodstawowa;
    }

    public double getPremia() {
        return premia;
    }

    public void setPlacaPodstawowa(double placaPodstawowa) {
        this.placaPodstawowa = placaPodstawowa;
    }

    public void setPremia(double premia) {
        this.premia = premia;
    }

    public String toString() {
        return placaPodstawowa + " " + premia + " ";
    }
    public boolean equals(Urzednicy o){
        if(this == null){
            return false;
        }else if(o instanceof Urzednicy){
            Urzednicy o1 = (Urzednicy) o;
            return (getPremia()==o1.getPremia()&& getPremia() == o1.getPremia() && super.getNazwisko()==o1.getNazwisko() && super.getEtat()==o1.getEtat() );
        }else
            return false;
    }
    public double wyplata(){
        double wyplata = 0;
        wyplata = (placaPodstawowa + placaPodstawowa*(premia/100 ))*etat;
        return wyplata;
    }




}

