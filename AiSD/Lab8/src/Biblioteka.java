public class Biblioteka {
    static Osoba[] tab = new Osoba[20];
    static int n = 10;
    public static void main(String[] args) {
        //wstaw do tablicy kilku pracowników oraz kilku czytelników
        tab[0] = new Pracownik();
        tab[1] = new Pracownik("Wroblewski","pesel","bibliotekarz",3000,500);
        tab[2] = new Pracownik("Sobieska","75646371","doradca",1500,300);
        tab[3] = new Pracownik("Więcek","75830468","dyrektor",5000,700);
        tab[4] = new Pracownik("Tabakow", "46084968", "bibliotekarz",4000,600);
        tab[5] = new Czytelnik();
        tab[6] = new Czytelnik("Kopernik","23454323",6);
        tab[7] = new Czytelnik("Lewandowski", "23567876",3);
        tab[8] = new Czytelnik("Morawiecki","09878658",1);
        tab[9] = new Czytelnik("Niedzielski","75738576",3);

        System.out.println("=============================================================================================");
        //wyświetl wszystkie osoby w kolejności występowania w tablicy

        for(int i =0; i < n; i++){
            System.out.println(tab[i].toString());
        }
        System.out.println("=============================================================================================");
        //wyświetl samych pracowników oraz ich nadgodziny

        for(int i =0; i < n; i++){
            if(tab[i] instanceof Pracownik){
                System.out.println("------------------------------------------------");
                System.out.println(tab[i].getNazwisko() );
                ((Pracownik) tab[i]).wyswietlLiczbeNadgodzin();
            }

    }
        System.out.println("=============================================================================================");
        //wyswietl samych czytelnukow

        for(int i =0; i < n; i++){
            if(tab[i] instanceof Czytelnik) {
                System.out.println("------------------------------------------------");
                System.out.println(tab[i].getNazwisko());
                ((Czytelnik) tab[i]).wyswietlWypozyczenia();
            }
        }
        System.out.println("=============================================================================================");

        //ile jest bibliotekarzy
        int ileBibliotekarzy = 0;
        for(int i =0; i < n; i++){
            if(tab[i] instanceof Pracownik && ((Pracownik) tab[i]).getStanowisko()=="bibliotekarz")
                ileBibliotekarzy++;
        }
        System.out.print("W bibliotece - ");
        if(ileBibliotekarzy==1)
            System.out.println(ileBibliotekarzy + " bibliotekarz!");
        else
            System.out.println(ileBibliotekarzy + " bibliotekarzy!");
        System.out.println("=============================================================================================");

        //najwiecej zarobil
        double max = ((Pracownik)tab[0]).oblicz();
        int index = 0;
        for(int i = 0; i<n; i++ ){
            if(tab[i] instanceof Pracownik &&((Pracownik)tab[i]).oblicz()>max){
                index = i;
                max = ((Pracownik)tab[i]).oblicz();
            }
        }
        System.out.println("Najwiecej zarobil " + tab[index].getNazwisko() + ", stanowisko - " + ((Pracownik)tab[index]).getStanowisko() + ", wyplata - " + max + ".");
    }
}
