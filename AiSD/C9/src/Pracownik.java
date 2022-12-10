
public class Pracownik implements Comparable<Pracownik>{
    String nazw, imie;
    int wiek;
    double etat;
    public int Comparable;

    public int compareTo(Pracownik ob) {
        int n = this.nazw.compareTo(ob.nazw);
        if(n==0){
            int i = this.imie.compareTo(ob.imie);
            if(i==0){
                if(wiek< ob.wiek)
                    return -1;
                if(wiek==ob.wiek)
                    return 0;
                return 1;
            }
            return i;
        }
        return n;
    }
}