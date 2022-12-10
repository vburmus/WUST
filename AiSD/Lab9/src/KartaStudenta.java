public class KartaStudenta implements KartaKlienta{
    int numer;
    String nazwisko;

    public KartaStudenta( int numer, String nazwisko){
        this.numer = numer;
        this.nazwisko = nazwisko;

    }

    public int rabat(){
        return 10;
    }
}
