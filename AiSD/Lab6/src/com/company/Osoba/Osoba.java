package com.company.Osoba;

import com.company.Konto.Konto;

public class Osoba {

    public static void aktywujKonto(Konto konto){
        konto.setJestAktywne(true);
    }

    public static void dezaktywujKonto(Konto konto){
        konto.setJestAktywne(false);
    }
}
