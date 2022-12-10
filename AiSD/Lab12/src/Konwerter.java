public class Konwerter {
    private static final double przelicznik =1.8;
    public static double FToC(double stopnieF){
        return (stopnieF-32)/przelicznik;

    }
    public static double CToF (double stopnieC){
        return (stopnieC*przelicznik)+32;
    }
}
