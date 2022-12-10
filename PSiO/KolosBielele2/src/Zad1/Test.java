package Zad1;

public class Test {
    public static void main(String[] args) {


        Lista lista = new Lista();
        lista.wpisanieKsiazki("Duda","Andrzej","Polska",545);
        lista.wpisanieKsiazki("Auda","Andrzej","Polska",541);
        lista.wpisanieKsiazki("Auda","Andrzej","Polska",541);
        lista.wyswietlenieWedlugAutorow();
        System.out.println("___________________________________________________");
        lista.wyswietlenieWedlugStron();
        System.out.println("___________________________________________________");
        lista.wyswietlenieWedlugTytulow("Auda","Andrzej");
        System.out.println("___________________________________________________");
        lista.wyswietlAutorow();
    }
}
