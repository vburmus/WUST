package com.company.Konto;

import com.company.Osoba.Osoba;

public class Konto {
    private Waluta waluta;
    private boolean jestAktywne = false;

    public Konto(){
        waluta = new Waluta(1);

    }
    public Konto(int w){
       waluta = new Waluta(w);


    }

    public Waluta getWaluta() {
        return waluta;
    }

    public boolean getjestAktywny() {
        return jestAktywne;
    }

    public void setJestAktywne(boolean jestAktywne) {
        this.jestAktywne = jestAktywne;
    }

    public void setWaluta(Waluta waluta) {
        this.waluta = waluta;
    }


    public void getStan(){
        System.out.println("waluta = " + waluta.getNazwa() + " jestAktywne = " + getjestAktywny());
    }


    public void aktywuj(){
        Osoba.aktywujKonto(this);
    }

    public void dezaktywuj(){
        Osoba.dezaktywujKonto(this);
    }
}
