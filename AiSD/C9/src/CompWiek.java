import java.util.Comparator;

public class CompWiek implements Comparator{
    public int compare(Pracownik ob1, Pracownik ob2){
        if(ob1.wiek==ob2.wiek) return 0;
        if(ob1.wiek > ob2.wiek) return 1;
        return -1;
    }
}
