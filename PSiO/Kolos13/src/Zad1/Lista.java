package Zad1;

import java.util.*;

public class Lista {
    ArrayList<Ksiazka> listaKsiazek ;
    Comparator compareTytul = new CompareTytul();
    Comparator compareAutor = new CompareAutor();
    Comparator compareLiczbaStron = new CompareStrony();
    public Lista(){
        listaKsiazek = new ArrayList<>();
    }
    public void wpisanieKsiazki(String nazwisko, String imie,String tytul,String wydawnictwo,int liczbaStron) {
        Autor autor = new Autor(nazwisko, imie);
        Ksiazka ksiazka = new Ksiazka(autor,tytul,wydawnictwo,liczbaStron);
        listaKsiazek.add(ksiazka);
    }
    public void wyswietlWgTytulow(){
        System.out.printf("%8s%18s%20s%15s","Autor","Tytul","Wydawnictwo","LiczbaStron\n");
        listaKsiazek.sort(compareTytul);
        for(int i = 0; i < listaKsiazek.size();i++){
            System.out.println(listaKsiazek.get(i).toString());
        }
    }
    public void wyswietlenieWgTytulowBezPowt(){
        System.out.printf("%8s%18s%20s%15s","Autor","Tytul","Wydawnictwo","LiczbaStron\n");
        TreeMap<String,Ksiazka> tyt = new TreeMap<>();
        for(int i =0; i< listaKsiazek.size();i++){
                tyt.put(listaKsiazek.get(i).getTytul(),listaKsiazek.get(i));
        }
        Iterator<String> i = tyt.keySet().iterator();
        while(i.hasNext()){
            String it = i.next();
            System.out.println(tyt.get(it).toString());
        }
    }
    public void wyswietlenieWgAutorowBezPowt(){
        System.out.printf("%8s%18s%20s%15s","Autor","Tytul","Wydawnictwo","LiczbaStron\n");
        TreeMap<String,Ksiazka> listaTyt = new TreeMap<>();
        for(int i =0; i< listaKsiazek.size();i++){
            listaTyt.put(listaKsiazek.get(i).getTytul(),listaKsiazek.get(i));
        }
        ArrayList<Ksiazka> listaTytBezPowt = new ArrayList<>();
        Iterator<String> tytIter = listaTyt.keySet().iterator();


            while(tytIter.hasNext()){
                String tytul = tytIter.next();
                listaTytBezPowt.add(listaTyt.get(tytul));
            }
            listaTytBezPowt.sort(compareAutor);
        for(int i = 0; i < listaTytBezPowt.size();i++){
            System.out.println(listaTytBezPowt.get(i).toString());
        }


    }
    public void wyswietlenieWedlugTytulowAutora(String nazwisko,String imie){
        System.out.printf("%8s%18s%20s%15s","Autor","Tytul","Wydawnictwo","LiczbaStron\n");
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
        System.out.printf("%8s","Autor\n");
        TreeMap<Autor,Ksiazka> autory = new TreeMap<>();

        for(int i =0; i< listaKsiazek.size();i++){
           autory.put(listaKsiazek.get(i).getAutor(),listaKsiazek.get(i));
        }
        Iterator<Autor> aut = autory.keySet().iterator();
        while(aut.hasNext()){
            Autor autorIter = aut.next();
            System.out.println(autory.get(autorIter).getAutor().toString());
        }
    }
    public void wyswietlWgWydawnictwa(String wydawnictwo){
        System.out.printf("%8s%18s%20s%15s","Autor","Tytul","Wydawnictwo","LiczbaStron\n");
        Autor autor = new Autor("Nowak","Jan");
        Ksiazka newKsiazka = new Ksiazka(autor,"Tytul",wydawnictwo,44);
        listaKsiazek.sort(compareLiczbaStron);
        for(int i =0; i < listaKsiazek.size();i++){
            if(listaKsiazek.get(i).equals(newKsiazka))
                System.out.println(listaKsiazek.get(i).toString());
        }
    }
    public void usunacWgWydawnictwa(String wydawnictwo){
        Autor autor = new Autor("Nowak","Jan");
        Ksiazka newKsiazka = new Ksiazka(autor,"Tytul",wydawnictwo,44);
        listaKsiazek.sort(compareLiczbaStron);
        for(int i =0; i < listaKsiazek.size();i++){
            if(listaKsiazek.get(i).getWydawnictwo()==wydawnictwo)
               listaKsiazek.remove(i);
        }
    }



}
