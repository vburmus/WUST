package Zad1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class ListaZaliczen {
    private ArrayList<Zaliczenie> lista = new ArrayList<>();
    public void dodanieStudenta(String nazwisko,String imie){
        Student newStudent = new Student(nazwisko,imie);
        Zaliczenie newZaliczenie = new Zaliczenie(newStudent);
        lista.add(newZaliczenie);
    }
    public void wpisanieZaliczenia(String nazwisko,String imie,String przedmiot,double ocena){
        Student studentZaliczenie = new Student(nazwisko, imie);
        for(int i = 0; i< lista.size();i++){
            if(lista.get(i).getStudent().equals(studentZaliczenie)){
                lista.get(i).dodacZaliczenie(przedmiot, ocena);
            }
        }
    }
    public void wyswietlenieStudentow(){
        Collections.sort(lista);
        for(int i =0;i<lista.size();i++){
            System.out.println(lista.get(i).getStudent().toString());
        }
    }














    public void wyswietlPrzedmioty(){
        TreeSet<String> list = new TreeSet<>();
        for(int i = 0; i<lista.size();i++){
            Iterator<String> k = lista.get(i).getZaliczenie().keySet().iterator();
            while(k.hasNext()){
                list.add(k.next());
            }
        }
        Iterator<String> i = list.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }





    public void listaZaliczenStudenta(String nazwisko, String imie){
        Student std = new Student(nazwisko, imie);
        for(int i =0; i< lista.size();i++){
            if(lista.get(i).getStudent().equals(std)){
                System.out.println(std.toString());
                Iterator<String> p = lista.get(i).getZaliczenie().keySet().iterator();
                String przedmiot;
                while(p.hasNext()){
                    przedmiot = p.next();
                    System.out.println(przedmiot + " " +lista.get(i).getZaliczenie().get(przedmiot));
                }
            }
        }
    }
    public void listaZaliczenStudentow(){
        for(int i =0; i< lista.size();i++){
                System.out.println(lista.get(i).getStudent().toString());
                Iterator<String> p = lista.get(i).getZaliczenie().keySet().iterator();
                String przedmiot;
                while(p.hasNext()){
                    przedmiot = p.next();
                    System.out.println(przedmiot + " " +lista.get(i).getZaliczenie().get(przedmiot));
                }
        }
    }
    public void  sredniaStudenta(String nazwisko,String imie){
        Student std = new Student(nazwisko, imie);
        for(int i =0; i< lista.size();i++){
            if(lista.get(i).getStudent().equals(std)){
                Iterator<String> p = lista.get(i).getZaliczenie().keySet().iterator();
                double liczbaOcen = 0;
                double suma =0 ;
                while(p.hasNext()){
                    liczbaOcen++;
                    suma += lista.get(i).getZaliczenie().get(p.next());
                }
                System.out.println("Srednia studenta:" + std.toString() + ", " + suma/liczbaOcen);
            }
        }
    }
    public void  srednia(String pisunEdwarda){
        double suma = 0;
        double liczbaOcen = 0;
        for(int i =0; i< lista.size();i++){
            Iterator<String> p = lista.get(i).getZaliczenie().keySet().iterator();
            String prz;

                while(p.hasNext()){
                    prz = p.next();
                    if(prz.equals(pisunEdwarda)){
                        liczbaOcen++;
                        suma+=lista.get(i).getZaliczenie().get(prz);
                    }
                }
        }
        System.out.println("Srednia = " + (suma/liczbaOcen));
    }

}
