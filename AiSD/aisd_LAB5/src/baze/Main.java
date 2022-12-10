package baze;

import Listy.FullStackException;

import java.util.Scanner;

public class Main {
    public static void menu() {
        System.out.println("""
                -------------------------------------------------
                1. Utworzenie nowej bazy danych;
                2. Odczyt bazy z pliku;
                3. Wyświetlenie wszystkich rekordów;
                4. Wyświetlenie danych jednego samochodu;
                5. Dopisanie nowego samochodu;
                6. Usunięcie samochodu z bazy;
                7. Aktualizowanie danych samochodu;
                8. Wyświetlanie danych samochodów o podanej marce;
                9. Wyświetlenie danych samochodów , wyprodukowanych w roku m;
                10. Wyświetlenie danych samochodów o cenach poniżej x;
                11. Zapis bazy do pliku;
                12. Parking.
                -------------------------------------------------""");
    }
    public static void main(String[] args) throws FullStackException {
        Scanner scan = new Scanner(System.in);
        Autosalon a1  = new Autosalon();
        int nr;
        String n = "1";

        menu();
        while (!n.equals("0")) {
            n = scan.nextLine();
            switch (n) {
                case "1":
                    Samochod car = new Samochod(1,"BMW","Coupe",2012,300,"blue",2);
                    Samochod car2 = new Samochod(3,"AUDI","Vagon",2011,50,"white",10);
                    Samochod car3 = new Samochod(2,"ABARTH","Hot-Hatch",2019,200,"black",22);
                    Samochod car4 = new Samochod(5,"MERCEDES","Vagon",2020,1000,"white",10);
                    Samochod car5 = new Samochod(4,"FORD","Hot-Hatch",2019,200,"black",22);
                    a1.addSamochod(car);
                    a1.addSamochod(car2);
                    a1.addSamochod(car3);
                    a1.addSamochod(car4);
                    a1.addSamochod(car5);
                    menu();

                    break;
                case "2":
                    a1.odzcyt("plik.txt");
                    menu();
                    break;
                case "3":
                    a1.wyswietl();
                    menu();
                    break;
                case "4":
                    System.out.println("Wprowadz numer:");
                     nr = scan.nextInt();
                    a1.wyswietlSamochod(nr);
                    menu();
                    break;
                case "5":
                    System.out.println("Wprowadz nrsilnika, marke,typ,date,cene,kolor,skladowanie:");
                    String line = scan.nextLine();
                    String[] arrayOfInf = line.split(" ");
                    if(a1.sprawdzicNrSilnika(Integer.parseInt(arrayOfInf[0])))
                    a1.addSamochod(new Samochod(Integer.parseInt(arrayOfInf[0]),arrayOfInf[1],arrayOfInf[2],Integer.parseInt(arrayOfInf[3]),Integer.parseInt(arrayOfInf[4]),arrayOfInf[5],Integer.parseInt(arrayOfInf[6])));
                    else
                        System.out.println("Juz jest samochod z takim numerem");
                    menu();
                    break;
                case "6":
                    System.out.println("Wprowadz numer:");
                    nr = scan.nextInt();
                    a1.usuniecie(nr);
                    menu();
                    break;
                case "7":
                    System.out.println("Wprowadz numer:");
                    nr = scan.nextInt();
                    a1.aktualizuj(nr);
                    menu();
                    break;
                case "8":
                    System.out.println("Wprowadz marke:");
                    String marka = scan.next();
                    a1.wyswietlMarka(marka);
                    menu();
                    break;
                case "9":
                    System.out.println("Wprowadz rok:");
                    nr = scan.nextInt();
                    a1.wyswietlRok(nr);
                    menu();
                    break;
                case "10":
                    System.out.println("Wprowadz cene:");
                    nr = scan.nextInt();
                    a1.wyswietlCena(nr);
                    menu();
                    break;
                case "11":
                    a1.zapisz("plik.txt");
                    menu();
                    break;
                case "12":
                    System.out.println("Wprowadz numer:");
                    nr = scan.nextInt();
                    a1.parking(nr);
                    break;
            }
        }
    }
    }

