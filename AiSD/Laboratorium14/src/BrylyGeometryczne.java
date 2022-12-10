import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BrylyGeometryczne {
    private ArrayList<Bryla> lista;
    Comparator compareKolor ;
    Comparator compareWysokosc ;
    Comparator compareKolorOrazWysokosc;

    public BrylyGeometryczne(){
        lista = new ArrayList<>();
    }
    class CompareKolor implements Comparator<Bryla>{
        public int compare(Bryla o1, Bryla o2) {
            return o1.getKolor().compareTo(o2.getKolor());
        }
    }
    class CompareWysokosc implements Comparator<Bryla>{
        public int compare(Bryla o1, Bryla o2) {
            return o1.getH() - o2.getH();
        }
    }
    class CompareKolorOrazWysokosc implements Comparator<Bryla>{
        public int compare(Bryla o1, Bryla o2) {

                String k1 = o1.getKolor();
                String k2 = ((Bryla) o2).getKolor();
                int Comp = k1.compareTo(k2);

                if (Comp != 0) {
                    return Comp;
                }

                int h1 = o1.getH();
                int h2 = o2.getH();
                return h1 - h2;
            }
        }

        public void dodawanieProstopadloscianu(String kolor, int h,int a,int b){
            Bryla newBryla = new Prostopadloscian(kolor,h,a,b);
            lista.add(newBryla);
        }
        public void dodawanieWalca(String kolor, int h,int r){
            Bryla newBryla = new Walec(kolor,h,r);
            lista.add(newBryla);
        }
        public void wyswietlanieListy(){
            for(int i = 0; i < lista.size();i++)
                System.out.println(String.format("%2d",i+1) + ".  " + lista.get(i).toString());
        }
        public void sortWgKoloru(){
            compareKolor = new CompareKolor();
            lista.sort(compareKolor);
        }
        public void sortWgWysokosci(){
            compareWysokosc  = new CompareWysokosc();
            lista.sort(compareWysokosc);
        }
        public void sortWgKoloruOrazWysokosci(){
            compareKolorOrazWysokosc = new CompareKolorOrazWysokosc();
            lista.sort(compareKolorOrazWysokosc);
        }
        public void szukajNajwObjetosc(){
            int index = 0;
            for(int i = 0; i < lista.size();i++ ){
                if(lista.get(i).Objetosc() > lista.get(index).Objetosc())
                index = i;
            }
            System.out.println("Najwieksza bryla - " + index + " {" + lista.get(index).toString()+"}");
        }
    public static void menu(){
        System.out.println("---------------------MENU------------------------");
        System.out.println("1 - Dodawanie bryl");
        System.out.println("2 - Dodawanie bryly recznie");
        System.out.println("3 - Wyswietlenie bryl");
        System.out.println("4 - Sortowanie wg. koloru" );
        System.out.println("5 - Sortowanie wg. wysokosci" );
        System.out.println("6 - Sortowanie wg. koloru oraz wysokosci" );
        System.out.println("7 - Najwieksza bryla" );
        System.out.println("0 - Wyjscie" );
    }
    public static void main(String[] args) {
        BrylyGeometryczne lista = new BrylyGeometryczne();
        Scanner read = new Scanner(System.in);
        String s;
        menu();
        while(!(s = read.nextLine()).equals("0")){
            switch (s){
                case "1":
                    lista.dodawanieWalca("Bialy",20,7);
                    lista.dodawanieWalca("Szary",20,5);
                    lista.dodawanieWalca("Zolty",10,9);
                    lista.dodawanieWalca("Bialy",30,5);
                    lista.dodawanieWalca("Szary",13,9);
                    lista.dodawanieWalca("Zolty",34,5);
                    lista.dodawanieProstopadloscianu("Bialy",10,40,10);
                    lista.dodawanieProstopadloscianu("Szary",12,10,30);
                    lista.dodawanieProstopadloscianu("Bialy",15,10,10);
                    lista.dodawanieProstopadloscianu("Zolty",23,25,10);
                    lista.dodawanieProstopadloscianu("Szary",11,11,11);
                    lista.dodawanieProstopadloscianu("Zolty",13,13,13);
                    System.out.println("Wypelniono");
                    break;
                case "2":
                    System.out.println("[1]Prostopadloscian\n[2]Walec");
                    String str = read.nextLine();
                    System.out.println("Wpisz kolor");
                    String kolor = read.nextLine();
                    System.out.println("Wpisz wysokosc");
                    int wysokosc = Integer.parseInt(read.nextLine());

                    if(str.equals("1")){
                        System.out.println("Wpisz A");
                        int A = Integer.parseInt(read.nextLine());
                        System.out.println("Wpisz B");
                        int B = Integer.parseInt(read.nextLine());
                        lista.dodawanieProstopadloscianu(kolor,wysokosc,A,B);
                    }else if(str.equals("2")){
                        System.out.println("Wpisz R");
                        int r = Integer.parseInt(read.nextLine());
                        lista.dodawanieWalca(kolor,wysokosc,r);
                    }
                    System.out.println("Wypelniono");
                    break;
                case "3":
                    System.out.println("_____________________________________________________________________________________________________________");
                    lista.wyswietlanieListy();
                    System.out.println("_____________________________________________________________________________________________________________");

                    break;
                case "4":
                    lista.sortWgKoloru();
                    System.out.println("Wypelniono");
                    break;
                case "5":
                    lista.sortWgWysokosci();
                    System.out.println("Wypelniono");
                    break;
                case "6":
                    lista.sortWgKoloruOrazWysokosci();
                    System.out.println("Wypelniono");
                    break;
                case "7":
                    System.out.println("_____________________________________________________________________________________________________________");
                    lista.szukajNajwObjetosc();
                    System.out.println("_____________________________________________________________________________________________________________");

            }
        menu();
        }
    }
    }


