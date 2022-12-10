package Zad1;

public class Test {
    public static void main(String[] args) {
        ListaZaliczen listaZaliczen = new ListaZaliczen();
        listaZaliczen.dodanieStudenta("Petrow","Volodya");
        listaZaliczen.wpisanieZaliczenia("Petrow", "Volodya","Logika",4.5);
        listaZaliczen.wpisanieZaliczenia("Petrow", "Volodya","OSK",3.5);
        listaZaliczen.wpisanieZaliczenia("Petrow", "Volodya","PSiO",2.5);
        listaZaliczen.wpisanieZaliczenia("Petrow", "Volodya","Algebra",5.5);
        listaZaliczen.dodanieStudenta("Burmus","Volodymyr");
        listaZaliczen.wpisanieZaliczenia("Burmus","Volodymyr","PSiO",4.5);
        listaZaliczen.wpisanieZaliczenia("Burmus","Volodymyr","OSK",4.5);
        listaZaliczen.wpisanieZaliczenia("Burmus","Volodymyr","Algebra",5.5);
        listaZaliczen.wpisanieZaliczenia("Burmus","Volodymyr","Logika",5.5);


        listaZaliczen.wyswietlenieStudentow();
        listaZaliczen.wyswietlPrzedmioty();
        listaZaliczen.listaZaliczenStudenta("Burmus","Volodymyr");
        listaZaliczen.listaZaliczenStudentow();
        listaZaliczen.sredniaStudenta("Burmus","Volodymyr");
        listaZaliczen.srednia("OSK");


    }
}
