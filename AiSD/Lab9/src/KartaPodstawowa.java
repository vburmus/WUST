public class KartaPodstawowa  implements KartaKlienta{
    int numer;
    String nazwisko;

    public KartaPodstawowa( int numer, String nazwisko){
       this.numer = numer;
       this.nazwisko = nazwisko;

    }

    public int rabat(){
        return 0;
    }
}
