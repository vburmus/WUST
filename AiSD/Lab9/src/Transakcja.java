public class Transakcja {
    private static int numerTransakcji = 1;
    private double kwota;
    private KartaKlienta karta;
    private int num;

    public Transakcja(){
        num = numerTransakcji ++;
        kwota = 20;
        karta = new KartaStudenta(1,"Duda");
    }
    public  Transakcja(double kwota, KartaKlienta karta){
        this.num = numerTransakcji ++;

        this.kwota = kwota;
        this.karta = karta;
    }

    public int getNumerTransakcji() {
        return numerTransakcji;
    }
    public double getKwota() {
        return kwota;
    }
    public KartaKlienta getKarta() {
        return karta;
    }
    public int getNum() {
        return num;
    }

    public void setKarta(KartaKlienta karta) {
        this.karta = karta;
    }
    public void setKwota(double kwota) {
        this.kwota = kwota;
    }
    public static void setNumerTransakcji(int numerTransakcji) {
        Transakcja.numerTransakcji = numerTransakcji;
    }

    public double kwotaDoSplaty(){
        return kwota - (kwota * karta.rabat()/100);
    }

    public String toString() {
        return String.format("%d%s%10.3f%s%13.3f%s%16d%s%19s",num ," ",kwota ," " , kwotaDoSplaty(), " " );
    }
}
