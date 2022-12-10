import java.io.*;
import java.util.Scanner;

public class Main1 {
    public static String nazwaPliku() {
        Scanner read = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        System.out.print("Nazwa - ");
        String nazwaPliku = read.nextLine();

        return nazwaPliku;
    }


    public static String wyraz(){
        Scanner read = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        System.out.print("Wyraz - ");
        String wyraz = read.nextLine();

        return wyraz;
    }
    public static void main(String[] args) {

        try(BufferedReader read = new BufferedReader(new FileReader(new File("text.txt")))){
            String wyraz = wyraz();
            String s = " ";
            String[] tablica = null;
            int liczbaZnakow = 0;
            int liczbaZnakowCzarnych = 0;
            int iloscWyrazWyst = 0;
            int liczbawierszy = 0;
            int liczbaWyrazow =0;
            while((s = read.readLine()) != null ) {
                liczbawierszy++;
                     {
                        tablica = s.split(" ");
                        liczbaWyrazow += tablica.length;
                        liczbaZnakow += s.length();
                        for (int i = 0; i < tablica.length; i++) {
                        liczbaZnakowCzarnych += tablica[i].length();
                            if (tablica[i].equals(wyraz)) {
                                iloscWyrazWyst++;
                            }
                         }
                    }
            }
                System.out.println("- liczba znaków wszystkich --->" + liczbaZnakow);
                System.out.println("- liczba znaków czarnych --->" + liczbaZnakowCzarnych);
                System.out.println("- liczba wyrazow --->" + liczbaWyrazow);
                System.out.println("- liczba  wierszy --->" + liczbawierszy);
                System.out.println("- liczba znaków podanych --->" + iloscWyrazWyst);

            }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
