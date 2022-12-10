package Zad1;

public class Test {
    public static void main(String[] args) {


        Lista lista = new Lista();
        lista.wpisanieKsiazki("Duda","Andrzej","Ksiazka2","Wydawnictwo1",545);
        lista.wpisanieKsiazki("Nowak","Andrzej","Ksiazka3","Wydawnictwo1",745);
        lista.wpisanieKsiazki("Kowalski","Jan","Ksiazka4","Wydawnictwo2",544);
        lista.wpisanieKsiazki("Duda","Andrzej","Ksiazka1","Wydawnictwo2",434);
        lista.wpisanieKsiazki("Duda","Andrzej","Ksiazka2","Wydawnictwo1",52);
        lista.wpisanieKsiazki("Nowak","Andrzej","Ksiazka3","Wydawnictwo3",45);

        lista.wyswietlWgTytulow();
        System.out.println("___________________________________________________");
        lista.wyswietlenieWgTytulowBezPowt();
        System.out.println("___________________________________________________");
        lista.wyswietlenieWgAutorowBezPowt();
        System.out.println("___________________________________________________");
        lista.wyswietlenieWedlugTytulowAutora("Duda","Andrzej");
        System.out.println("___________________________________________________");
        lista.wyswietlAutorow();

        System.out.println("___________________________________________________");
        lista.wyswietlWgWydawnictwa("Wydawnictwo2");
        System.out.println("___________________________________________________");
        lista.usunacWgWydawnictwa("Wydawnictwo2");
        System.out.println("___________________________________________________");
        lista.wyswietlWgWydawnictwa("Wydawnictwo2");
        System.out.println("___________________________________________________");
    }
    }