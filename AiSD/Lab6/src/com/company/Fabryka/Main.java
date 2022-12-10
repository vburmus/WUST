package com.company.Fabryka;

import java.util.Random;

public class Main {
    public static void wyswietl(Produkt[] tab){
        for (int i = 0; i < tab.length; i++){

            System.out.print("Numer elementu - " + i + " Kod - "+ tab[i].getKod() );
            System.out.println(" Cena - " + ((double)Math.round(tab[i].getCena()*100)/100));


                    }
    }
    public static Produkt znajdowanie(Produkt[] tab){
        double cena1;
        cena1 = tab[0].getCena();
        Produkt numer = new Produkt();
        for (int i = 0; i < tab.length; i++){
            if(cena1 > tab[i].getCena()){
                cena1 = tab[i].getCena();
                numer = tab[i];
            }

        }
        return numer ;

    }
    public static void main(String[] args) {
        Random generator = new Random();
        int n = 5;
        Produkt[] Fabryka = new Produkt[n];
        for (int i = 0; i < Fabryka.length; i++){
            Fabryka[i] = new Produkt(generator.nextInt(10), generator.nextDouble() * 10);
        }
        wyswietl(Fabryka);
        System.out.println("Kod najmniejszego elementu - " + znajdowanie(Fabryka).getKod() + ".  O cenie - " +((double)Math.round(znajdowanie(Fabryka).getCena()*100)/100) );
    }
}
