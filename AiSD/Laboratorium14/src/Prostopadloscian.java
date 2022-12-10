public class Prostopadloscian extends Bryla {
    private int a;
    private int b;
    private boolean jestSzescianem;
    public Prostopadloscian(){
        super("bialy",20);
        a = 10;
        b = 20;
        jestSzescianem = false;
    }
    public Prostopadloscian(String kolor,int h,int a,int b){
        super(kolor, h);
        this.a = a;
        this.b = b;
        if(a==b&&b==h){
            this.jestSzescianem = true;
        }else{
            this.jestSzescianem = false;
        }
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public boolean isJestSzescianem() {
        return jestSzescianem;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setJestSzescianem(boolean jestSzescianem) {
        this.jestSzescianem = jestSzescianem;
    }

    public double Objetosc() {
        return getA()*getB()*getH();
    }


    public String toString() {
        return super.getClass().getName()+ ": kolor - " + getKolor() + "     H - " + getH() +
                "    A - " + getA() + "    B - " + getB()  + "     Ma V = " + this.Objetosc() + "    jestSzescianem - " + isJestSzescianem();
    }
}
