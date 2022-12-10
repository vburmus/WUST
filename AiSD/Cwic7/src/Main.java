public class Main {


    public static void main(String[] args) {
        Tablica tab1 = new Tablica(10);
        Pracownik osoba1 = new Urzednicy("Duedek",1300,1,10);
        Pracownik osoba2 = new Robotnicy();
        tab1.zatrudnienie(osoba1);
        tab1.zatrudnienie(osoba2);
        System.out.println(osoba1.wyplata());
        System.out.println(osoba2.wyplata());

        tab1.wydrukListyPlac();
    }}
