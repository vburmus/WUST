import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Sklep {
    private  static Transakcja[] tablica = new Transakcja[99];

    public static  void wstawienie(){
        KartaKlienta karta1 = new KartaPodstawowa(1,"Morawiecki");
        KartaKlienta karta2 = new KartaStudenta(2,"Zywiecki");
        KartaKlienta karta3 = new KartaSeniora(3, "Kebz");
        tablica[0] = new Transakcja(100,karta1);
        tablica[1] = new Transakcja(120,karta2);
        tablica[2] = new Transakcja(100,karta3);
    }
    public static  void wyswietlenie(){
        System.out.printf("%s%10s%20s\n","№","Kwota", "Kwota z rabatem");
      for(int i=0; tablica[i]!=null; i++)
          System.out.println(tablica[i].toString());
        System.out.println("____________________________________________________________________________________" );
       }
    public static int wolne() {

        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] == null)
                return i;

        }
        return -1;
    }
    public static void dodacTransakcje(){
        Scanner read = new Scanner(System.in);
        System.out.print("Wpisz nazwisko ----> ");
        String nazwisko = read.nextLine();
        System.out.print("\n" + "Wpisz numer ----> ");
        int numer = read.nextInt();
        System.out.print("\n" + "Wpisz kwote ----> ");
        double sum = read.nextDouble();
        System.out.print("\n" + "Wpisz typ karty: 1 - Podstawowa, 2 - Studenta, 3 - Seniora ----> ");
        int typ = read.nextInt();
        read.nextLine();
        if(wolne()!=-1) {
            switch (typ) {
                case 1:
                    KartaKlienta karta1 = new KartaPodstawowa(numer, nazwisko);
                    tablica[wolne()] = new Transakcja(sum,karta1);
                    System.out.println("Karta zostala wpisana");
                    System.out.println("____________________________________________________________________________________" );
                    break;
                case 2:
                    KartaKlienta karta2 = new KartaStudenta(numer, nazwisko);
                    tablica[wolne()] = new Transakcja(sum,karta2);
                    System.out.println("Karta zostala wpisana");
                    System.out.println("____________________________________________________________________________________" );
                    break;
                case 3:
                    KartaKlienta karta3 = new KartaSeniora(numer, nazwisko);
                    tablica[wolne()] = new Transakcja(sum,karta3);
                    System.out.println("Karta zostala wpisana");
                    System.out.println("____________________________________________________________________________________" );
                    break;
                default:
                    System.out.println("Nieprawidlowa karta");
                    System.out.println("____________________________________________________________________________________" );
                    break;
            }
        }

    }
    public static void ileSeniorow() {
        int count = 0;

        for (int i = 0; i < tablica[0].getNumerTransakcji(); i++) {
            if (tablica[i] != null) {
                if (tablica[i].getKarta() instanceof KartaSeniora)
                    count++;
            } else
                break;
        }
        System.out.println("Transakcji z karta seniora - " + count);
        System.out.println("____________________________________________________________________________________" );
    }
    public static void jakiStudent() {
        double max = tablica[0].getKwota();
        int index = 0;
        for (int i = 0; i < tablica[0].getNumerTransakcji(); i++) {
            if (tablica[i] != null && tablica[i].getKarta() instanceof KartaStudenta && tablica[i].getKwota()>max) {
                max = tablica[i].getKwota();
                index =i;
            }
                    }
        System.out.printf("%25s%10s%20s\n","№","Kwota", "Kwota z rabatem");
        System.out.println("Najwieksza transakcja - " + tablica[index].toString());
        System.out.println("____________________________________________________________________________________" );
    }
    public static  void zapisanie() throws IOException{
        File file = new File("wynik.txt");

            BufferedWriter writePlik = new BufferedWriter(new FileWriter(file));

        String wynik = "";
        for(int i = 0; i< tablica[0].getNumerTransakcji(); i++) {
            if(tablica[i]!=null && tablica[i].getKarta() instanceof KartaStudenta) {
                wynik = tablica[i].toString();
                writePlik.write(wynik);
            }
        }
        writePlik.close();
    }
    public static void menuSklepu(){

        System.out.println("1) Wstawianie do tablicy kilka transakcji z różnymi kartami" );
        System.out.println("2) Wyświetlenie utworzonych transakcji" );
        System.out.println("3) Dodanie jednej transakcji" );
        System.out.println("4) Policzenie ile było transakcji z KartąSeniora" );
        System.out.println("5) Wyświetlenie klienta z KartąStudenta, który zapłacił najwięce" );
        System.out.println("6) Zapisanie (BufferedWriter) do pliku tekstowego transakcji z użyciem KartyStudenta " );
        System.out.println("0) Wyjscie" );
        System.out.println("____________________________________________________________________________________" );
        System.out.print("Wpisz numer metody ---> ");

    }
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        //menu______________________________________________________________________________
        int numer=-1;

        while(numer!=0) {
            menuSklepu();
            numer = reader.nextInt();
            System.out.println("____________________________________________________________________________________" );
            switch (numer){
                case 1:
                    wstawienie();
                    break;
                case 2:
                    wyswietlenie();
                    break;
                case 3:
                    dodacTransakcje();
                    break;
                case 4:
                    ileSeniorow();
                    break;
                case 5:
                    jakiStudent();
                    break;
                case 6:
                    zapisanie();
                    break;


            }
        }
        reader.close();
    }
}
