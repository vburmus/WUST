import java.util.Comparator;

public abstract class Bryla  {
    private String kolor;
    private int  h;

    public Bryla(){
        kolor = "bialy";
        h = 20;
    }
    public Bryla(String kolor,int h){
        this.h=h;
        this.kolor=kolor;
    }

    public String getKolor() {
        return kolor;
    }

    public int getH() {
        return h;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public void setH(int h) {
        this.h = h;
    }

    public abstract double Objetosc();

}
