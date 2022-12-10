package com.company.Fabryka;

public class Produkt {
    private int kod;
    private double cena;
    public Produkt(int kod,double cena){
        this.kod = kod;
        this.cena = cena;

    }
    public Produkt(){
        kod = 1;
        cena = 1;

    }

    public double getCena() {
        return cena;
    }

    public int getKod() {
        return kod;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setKod(int kod) {
        this.kod = kod;
    }
    public void getStan(){
        System.out.println("Kod - " + getKod() + " Cena - " + getCena());
    }
}
