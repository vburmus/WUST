package Zad1;

import java.util.*;

public class Lista {
ArrayList<Ksiazka> listaKsiazek ;
Comparator Comparator1  = new CompareAutor();
Comparator Comparator2 = new CompareStrony();
public Lista(){
    listaKsiazek = new ArrayList<>();
}

    public void wpisanieKsiazki(String nazwisko, String imie, String tytul, int liczba){
    Autor autor = new Autor(nazwisko, imie);
    Ksiazka ksiazka = new Ksiazka(autor,tytul,liczba);
    listaKsiazek.add(ksiazka);

}

    public ArrayList<Ksiazka> getListaKsiazek() {
        return listaKsiazek;
    }

    public void wyswietlenieWedlugAutorow() {
        listaKsiazek.sort(Comparator1);
        for (int i = 0; i < listaKsiazek.size(); i++) {
            System.out.println(listaKsiazek.get(i).toString());
        }
    }
        public void wyswietlenieWedlugStron(){
            listaKsiazek.sort(Comparator.comparing(Ksiazka::getAutor));
            for(int i =0; i< listaKsiazek.size();i++){
                System.out.println(listaKsiazek.get(i).toString());
            }

}
        public void wyswietlenieWedlugTytulow(String nazwisko,String imie){
            Autor autor = new Autor(nazwisko,imie);
            TreeMap<String,Ksiazka> set = new TreeMap<>();

            for(int i =0; i< listaKsiazek.size();i++){
                if(autor.equals(listaKsiazek.get(i).getAutor()))
                set.put(listaKsiazek.get(i).getTytul(),listaKsiazek.get(i));
            }

            Iterator<String> i = set.keySet().iterator();
            while(i.hasNext()){
                String it = i.next();
                System.out.println(set.get(it).toString());
            }
        }
        public void wyswietlAutorow(){
            listaKsiazek.sort(Comparator1);
            for(int i =0; i< listaKsiazek.size();i++){
                System.out.println(listaKsiazek.get(i).getAutor());
            }
        }
}
