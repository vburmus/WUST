
package com.company;

public class Zad1 {
    static class Latarka{
        /*
Zamodeluj działanie latarki (zdefiniuj klasę Latarka).------------
---------------------------------------------------------------------------------
Latarkę można włączać i wyłączać (stan latarki: 1-wlaczony, 0-wylaczony).--------
---------------------------------------------------------------------------------
Po włączeniu latarka świeci białym światłem.-------------------------------------
---------------------------
Kolor światła można zmienić na zielony lub czerwony (kolor: 0-bialy, 1-zielony, 2-czerwony).
---------------------------
Metody:
Wlacz – włączenie latarki, latarka świeci światłem białym,

Wylacz – wyłaczenie latarki,

ZmienKolor(kolor) – zmienia kolor światła na podany,

Drukuj – drukuje: latarka wyłączona lub latarka włączona i świeci światłem ...
---------------------------
Napisz program (klasa Main) demonstrujący działanie powyższej klasy.
*/
        int stan;
        int kolor;

        // Konstruktor
        public Latarka(int stan, int kolor){
            this.stan = stan;
            this.kolor = kolor;

        }


        // Getters
        public int getStan(){
            return stan;
        }
        public int getKolor(){
            return kolor;
        }


        // Setters
        public void setStan(){
            this.stan = stan;
        }
        public void setKolor(){
            this.kolor = kolor;
        }


        // Metody
        public void wlacz(){
            kolor = 0;
            stan = 1;


        }

        public void wylacz(){
            stan = 0;
        }

        public void zmienKolor(int kolor){
            this.kolor = kolor;
        }

        public void drukuj(){
            if (getStan() == 1){
                switch (kolor){
                    case 1:
                        System.out.println("Latarka wlączona i świeci światłem ZIELONYM");
                        break;
                    case 2:
                        System.out.println("Latarka wlączona i świeci światłem CZERWONYM");
                        break;
                    case 0:
                        System.out.println("Latarka wlączona i świeci światłem BIALYM");
                        break;
                }
            }else
                System.out.println("Latarka wylączona");
        }

    }
    public static void main(String[] args) {
        Latarka latarka1 = new Latarka(0,2);
        latarka1.drukuj();
        latarka1.wlacz();
        latarka1.drukuj();
        latarka1.zmienKolor(1);
        latarka1.drukuj();
        latarka1.wylacz();
        latarka1.drukuj();


    }
}
