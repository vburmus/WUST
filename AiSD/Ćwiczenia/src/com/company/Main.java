package com.company;

public class Main {


    public static class Osoba{
      static  String nazwisko;
       static String imie;
        String pers;
        public Osoba(String nazwisko, String imie){
            this.imie = imie;
            this.nazwisko = nazwisko;
        }
        public String getOsoba(){
            pers = imie + " " +nazwisko;
            return pers;
        }

    }
    public static class Pokoj{
        String numerPokoju;
        public Pokoj(String numerPokoju, String pers){
            this.numerPokoju = numerPokoju;
        }


    }
    public static void main(String[] args) {
        Osoba osoba1 = new Osoba("HUJ","PIZDA");
        Pokoj pokoj1 = new Pokoj("1",osoba1.getOsoba());
    }
}
