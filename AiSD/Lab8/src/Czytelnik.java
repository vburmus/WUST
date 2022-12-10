import java.util.Random;

public class Czytelnik extends Osoba{
    Random generator = new Random();
    private int n;
    private Ksiazka[] wypozyczenia;
    public Czytelnik() {
        nazwisko = "Hubski";
        pesel = "04072011128";
        n = 5;
        wypozyczenia = new Ksiazka[n];
        for (int i = 0; i < n; i++) {
            wypozyczenia[i] = new Ksiazka((generator.nextInt(10) + 1), ((double) Math.round(generator.nextDouble() * 1000 + 1) / 100), generator.nextBoolean());

        }
    }
    public Czytelnik(String nazwisko,String pesel, int n){
        super(nazwisko,pesel);

            wypozyczenia = new Ksiazka[n];
        for(int i =0; i < n; i++){
            wypozyczenia[i] = new Ksiazka((generator.nextInt(10)+1),((double)Math.round(generator.nextDouble()*1000+1)/100), generator.nextBoolean());
        }
    }

    public int getN() {
        return n;
    }

    public Ksiazka[] getWypozyczenia() {
        return wypozyczenia;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setWypozyczenia(Ksiazka[] wypozyczenia) {
        this.wypozyczenia = wypozyczenia;
    }
    public double oblicz(){
        double sum = 0;
        for (int i = 0; i < getWypozyczenia().length; i++){
            sum+= getWypozyczenia()[i].getKara();
        }
        return sum;
    }
    public String toString(){
        return "Czytelnik: " + getNazwisko() + ", pesel: " + getPesel() ;
    }
    public void wyswietlWypozyczenia(){
        for (int i = 0; i< getWypozyczenia().length; i++){
            System.out.println(getWypozyczenia()[i].toString());
        }
    }
}
