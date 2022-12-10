package Zad1;

public class Main {
    public static double gX(double x,int n){
        double g = x;
        double licznik = -(Math.pow(x,3));
        double mianownik = 3;
        for(int i = 1; i<n;i++){
            g +=(licznik/mianownik);
            mianownik+=2;
            licznik*=-(Math.pow(x,2));
        }
        return g;
    }
    public static void tabGlowna(double[] tabX,int n){
        System.out.printf("%8s%22s","x","g(x)");
        System.out.println();
        for (int i = 0; i < tabX.length; i++) {
            System.out.printf("%10.2f%20.4f\n", tabX[i],gX(tabX[i],n));
        }
    }
    public static void main(String[] args) {
        double[] tabX = {-1,0,1,0.5};
        int n =3;
        tabGlowna(tabX,n);
    }
}
