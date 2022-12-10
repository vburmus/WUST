public class Zad1 {
    public static double oblicz( double n,double x){
        double g = 1;
        double licznik = 1;
        double mianownik;

        for(int i = 1; i<n;i++){
            mianownik = 1;
            for (int j = 1; j <= 2*i;j++)
                mianownik *= j;
            licznik *= -(x*x);
            g += (licznik/mianownik);
        }
        return g;
    }
    public static void wyswietlij(double a, double b, double h,int n) {
        double k = (b-a)/h;
        System.out.printf("%2s%22s","x","g(x)");
        System.out.println();
        for (int i = 0; i < k; i++) {
            System.out.printf("%1.2f%20.4f\n",(a+i*h),oblicz(n,(a+i*h)));
        }
    }
    public static void main(String[] args) {
        double a = 1;
        double b = 3;
        double h = 1;
        int n = 2;
        wyswietlij(a,b,h,n);


    }

}




