package com.company.Konto;

public class Waluta {
    private int nazwa;
    public Waluta(int nazwa){
        this.nazwa = nazwa;

    }
    public Waluta(){
       nazwa = 1;

    }

    public int getNazwa() {
        return nazwa;
    }

    public void setNazwa(int nazwa) {
        this.nazwa = nazwa;
    }
}
