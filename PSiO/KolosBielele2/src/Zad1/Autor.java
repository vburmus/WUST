package Zad1;

import java.util.Objects;

public class Autor implements Comparable<Autor>{
    private String nazwisko;
    private String imie;
    public Autor(String nazwisko,String imie){
        this.nazwisko = nazwisko;
        this.imie = imie;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public boolean equals(Object o) {
       if(this==null) return false;
       if(o instanceof Autor){
           Autor ob = (Autor) o;
           if(this.getImie()==ob.getImie()&&  this.getNazwisko()==ob.getNazwisko())return  true;
       }
       return false;
    }

    public String toString() {
        return  nazwisko + ' ' + imie;
    }


    public int compareTo(Autor o) {
        return this.toString().compareTo(o.toString());
    }
}
