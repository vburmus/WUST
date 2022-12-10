public class Walec extends Bryla{
    private int r;
    public Walec(){
    super("bialy",10);
    r = 5;
    }

    public Walec(String kolor,int h,int r){
        super(kolor, h);
        this.r = r;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }


    public double Objetosc() {
        return Math.round(100 * Math.PI * Math.pow(getR(),2)*getH())/100;
    }
    public String toString(){
        return super.getClass().getName()+  ":----------- kolor - " + getKolor() + "     H - " + getH() + "    R - " + getR() + " -------------- Ma V = " + this.Objetosc();
    }

}
