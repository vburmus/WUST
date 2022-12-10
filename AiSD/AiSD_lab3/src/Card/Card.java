package Card;

import java.util.Objects;
import java.util.Random;

public class Card {
    private int wartosc;
    private int kolor;
    private boolean znacznik;
    public Card(int wartosc, int kolor){
        this.wartosc = wartosc;
        this.kolor = kolor;
        if(wartosc == 14)
            znacznik = false;
        else
            znacznik = true;

    }

        public Card(){
            kolor = 1;
            wartosc = 1;
            znacznik = false;
        }

    public int getKolor() {
        return kolor;
    }
    public int getWartosc() {
        return wartosc;
    }
    public boolean isZnacznik() {
        return znacznik;
    }
    public void setKolor(int kolor) {
        this.kolor = kolor;
    }
    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }
    public void setZnacznik(boolean znacznik) {
        this.znacznik = znacznik;
    }


    public boolean equals(Card o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card karta = (Card) o;
        return wartosc == karta.wartosc && kolor == karta.kolor && znacznik == karta.znacznik;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wartosc, kolor, znacznik);
    }

    @Override
    public String toString() {
        if(getWartosc()==14)
            return "-----------()----------";
            else
                return String.format("|%5d|%5d|",getWartosc() , getKolor());

    }
}
