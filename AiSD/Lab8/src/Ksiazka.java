public class Ksiazka {
    private int sygnatura;
    private double kara;
    private boolean czyOddanaWTerminie;
    public Ksiazka(){
        sygnatura = 0;
        kara = 0;
        czyOddanaWTerminie = true;
    }
    public Ksiazka(int sygnatura, double kara, boolean czyOddanaWTerminie){
        this.sygnatura = sygnatura;
        if(czyOddanaWTerminie==true)
            kara = 0;
        else
             this.kara = kara;

    }

    public double getKara() {
        return kara;
    }

    public int getSygnatura() {
        return sygnatura;
    }

    public void setCzyOddanaWTerminie(boolean czyOddanaWTerminie) {
        this.czyOddanaWTerminie = czyOddanaWTerminie;
    }

    public void setKara(double kara) {
        this.kara = kara;
    }

    public void setSygnatura(int sygnatura) {
        this.sygnatura = sygnatura;
    }

    public String toString() {
        return  sygnatura + " " + kara + " " + czyOddanaWTerminie;
    }
}
