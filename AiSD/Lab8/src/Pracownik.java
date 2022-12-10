import java.util.Arrays;
import java.util.Random;

public class Pracownik extends Osoba{
    Random generator = new Random();
    private String stanowisko;
    private int pensja;
    private int stawka;
    private int[] t = new int[5];
   public Pracownik(){

        stanowisko = "bibliotekarz";
        pensja = 2000;
        stawka = 400;
       for(int i = 0; i<t.length; i++){
           t[i] = generator.nextInt(4)+1;
       }
    }
    public Pracownik(String nazwisko, String pesel, String stanowisko, int pensja, int stawka){
       super(nazwisko,pesel);
       this.stanowisko = stanowisko;
       this.pensja = pensja;
       this.stawka = stawka;
       for(int i = 0; i<t.length; i++){
           t[i] = generator.nextInt(4)+1;
       }

    }

    public int getPensja() {
        return pensja;
    }

    public int getStawka() {
        return stawka;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStawka(int stawka) {
        this.stawka = stawka;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    public double oblicz(){
       double  liczbaGodzin = 0;
       for (int i = 0; i < t.length; i++)
            liczbaGodzin+=t[i];

       return getPensja()+getStawka()*liczbaGodzin;
    }


    public String toString() {
        return "Pracownik: "+ nazwisko + " " + pesel + " [ stanowisko = " + stanowisko + ", pensja = " + pensja + ", stawka = " + stawka + " ]." ;
    }
    public void wyswietlLiczbeNadgodzin(){
        for (int i = 0; i < t.length; i++){
            System.out.print("Dzien tygodnia nr." + (i+1) + " ---> " + t[i]);
            if(t[i]==1)
                System.out.println(" nadgodzina.");
            else
                System.out.println(" nadgodzin.");
        }
    }
    public boolean jestBibliotekarzem(){
       if(getStanowisko() == "bibliotekarz")
           return true;
       else
           return false;
    }

}
