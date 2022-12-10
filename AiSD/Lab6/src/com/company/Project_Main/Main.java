package com.company.Project_Main;

import com.company.Konto.Konto;
import com.company.Osoba.Osoba;

import java.util.Random;

public class Main {

    public static void wyswietl(Konto[] tab){
        for (int i = 0; i < tab.length; i++){
            System.out.print("Konto o indeksie = " + i + " " );
            tab[i].getStan();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Random generator = new Random();
        int iloscKont = 5;


        Konto[] bank = new Konto[iloscKont];
        for (int i = 0; i < bank.length; i++){

            bank[i] = new Konto(generator.nextInt(4)+1);

        }
        wyswietl(bank);

        bank[0].aktywuj();
        wyswietl(bank);
        bank[0].dezaktywuj();
        wyswietl(bank);
    }
}
