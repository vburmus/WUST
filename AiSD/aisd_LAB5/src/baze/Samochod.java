package baze;

import java.io.Serializable;
import java.util.Objects;

public class Samochod implements Serializable {
    private int nr_silnika,data,cena,skladowanie;
    private String marka,typ,kolor;
    private double przecena;
    public Samochod(){
        nr_silnika = 0;
        data = 0;
        cena = 0;
        skladowanie = 0;
        marka = null;
        typ = null;
        kolor = null;
        przecena = cena;
    }
    public Samochod(int nr_silnika, String marka, String typ, int data, int cena, String kolor, int skladowanie){
        this.nr_silnika = nr_silnika;
        this.marka = marka;
        this.typ = typ;
        this.data = data;
        this.cena = cena;
        this.kolor = kolor;
        this.skladowanie = skladowanie;
        if(skladowanie>=15)
            this.przecena = cena * 0.85;
        else if(skladowanie>=6)
            this.przecena = cena * 0.94;
        else
            this.przecena = cena;
    }

    public String getKolor() {
        return kolor;
    }
    public String getMarka() {
        return marka;
    }
    public double getPrzecena() {
        return przecena;
    }
    public int getCena() {
        return cena;
    }
    public int getData() {
        return data;
    }
    public int getNr_silnika() {
        return nr_silnika;
    }
    public int getSkladowanie() {
        return skladowanie;
    }
    public String getTyp() {
        return typ;
    }
    public void setKolor(String kolor) {
        this.kolor = kolor;
    }
    public void setMarka(String marka) {
        this.marka = marka;
    }
    public void setCena(int cena) {
        this.cena = cena;
    }
    public void setData(int data) {
        this.data = data;
    }
    public void setNr_silnika(int nr_silnika) {
        this.nr_silnika = nr_silnika;
    }
    public void setSkladowanie(int skladowanie) {
        this.skladowanie = skladowanie;
        if(skladowanie>=15)
            this.przecena = this.getCena() * 0.85;
        else if(skladowanie>=6)
            this.przecena = this.getCena() * 0.94;
        else
            this.przecena = this.getCena();

    }
    public void setTyp(String typ) {
        this.typ = typ;
    }
    public boolean equals(Samochod o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Samochod car = (Samochod) o;
        return nr_silnika == car.nr_silnika && data == car.data && cena == car.cena && skladowanie == car.skladowanie && Double.compare(car.przecena, przecena) == 0 && Objects.equals(marka, car.marka) && Objects.equals(typ, car.typ) && Objects.equals(kolor, car.kolor);
    }
    @Override
    public String toString() {
        return getNr_silnika() + " "  + getMarka() + " " + getTyp() + " " + getData() + " " + getCena() + " " + getKolor() + " " + getSkladowanie() + " " + getPrzecena();
    }
}
