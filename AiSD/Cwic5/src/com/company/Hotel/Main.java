package com.company.Hotel;
import com.company.Osoba.Osoba;
import com.company.Hotel.Main;
import com.company.Pokoj.Pokoj;

public class Main {
    public static class Hotel {

        private Pokoj[] hotel;
//il wolnych, czy jest wolne pokoje, numer wolnego,
        //zamelduj,wymelduj
        //czy wynajmuje pokoj, wymelduj osobe
        //konstrukktor
        public Hotel(int ilePokojow) {
            hotel = new Pokoj[ilePokojow];
            for (int i = 0; i < hotel.length; i++) {
                hotel[i] = new Pokoj();
            }
        }
        //Metody
            public  int iloscWolnych(){
                int counter = 0;
                for(int i = 0; i < hotel.length; i++) {
                    if (hotel[i].osoba == null) counter++;
                }
                return counter;
            }
            public boolean czyJestWolny(){
                if(iloscWolnych() == 0) return false;
                else return true;
            }
            public int numerWolnego(){

                for(int i = 0; i < hotel.length; i++) {
                    if (hotel[i].osoba == null) return i;
                }
                return -1;
            }
            public void zameldujOsobe(Osoba osoba){
                hotel[numerWolnego()].osoba = osoba;
            }
             public void wymeldujOsobe(int numerPokoju){
                hotel[numerPokoju].osoba = null;
            }
            public boolean czyWynajmujeOsoba(String nazwisko){
                for (Pokoj pokoj : hotel){
                     if(pokoj.osoba.getNazwisko() == nazwisko)
                        return true;
            }
                return false;
                    }
            public void wymeldujOsobe(String nazwisko){
                for (Pokoj pokoj : hotel) {
                    if (pokoj.osoba.getNazwisko() == nazwisko) pokoj.osoba = null;
                }
            }


    }


        public static void main(String[] args) {
            Hotel hotel = new Hotel(5);
            Osoba klient = new Osoba("Frei","Zalupkin");
            hotel.zameldujOsobe(klient);
            System.out.println(hotel.iloscWolnych());
            System.out.println(hotel.czyJestWolny());
            System.out.println(hotel.numerWolnego());
            System.out.println(hotel.czyWynajmujeOsoba("Zalupkin"));




        }
    }

