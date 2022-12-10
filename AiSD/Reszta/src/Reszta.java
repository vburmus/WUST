
import java.util.Scanner;
import java.util.InputMismatchException;

public class Reszta {
    public static double odczyt(){
        double reszta = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj reszte: ");

        try {
            reszta = sc.nextDouble();
        }
        catch (InputMismatchException ex) {
            System.out.println("Nieprawidlowa wartosc");
            return -1;
        }
        return reszta;
    }
    public static void wydanieReszty(double reszta){

        String wynik = "Reszta:\n";
        final double[] NOMINALY = {200.0,100.0,50.0,20.0,10.0,5.0,2.0,1.0,0.5,0.2,0.1,0.05,0.02,0.01};

        for (int i = 0; ((i < NOMINALY.length) && (reszta > 0.00)); i++) {

            if (reszta >= NOMINALY[i]) {

                int temp = (int)Math.floor(reszta/NOMINALY[i]);
                wynik += NOMINALY[i] + " PLN x " + temp + "\n";
                reszta = (double) Math.round(100*(reszta-(temp*NOMINALY[i])))/100;
            }
        }
        System.out.println(wynik);
    }
    public static void main(String[] args) {

        double reszta = odczyt();
        if(reszta!=-1)
            wydanieReszty(reszta);
    }
}