public class KartaSeniora implements KartaKlienta{
    int numer;
    String nazwisko;

    public KartaSeniora( int numer, String nazwisko){
        this.numer = numer;
        this.nazwisko = nazwisko;

    }

    public int rabat(){
        return 15;
    }
}
