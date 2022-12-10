import java.util.Arrays;

public class Firma {

    Pracownik[] firma;
    int ile;
    public void sortuj() {
        Arrays.sort(firma, 0, ile);
    }
    public void sortujWiek(){
        CompWiek comp = new CompWiek();
        Arrays.sort(firma,comp);
    }

    }

