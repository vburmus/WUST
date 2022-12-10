
import java.io.IOException;


public class Main {

    public static void main (String [] args) throws IOException {

        RBT tree = Oper.fillingTheTree();
        tree.showWords();
        System.out.println("-------------------------");
        tree.levelOrder();
        System.out.println("-------------------------");
        tree.delete("nie");
        tree.showWords();
        /*Parasol noś i przy pogodzie,
                nie tylko gdy deszcz pada,
        choć dzisiaj nie jest to już w modzie,
        parasol noś i przy pogodzie.
                i przy najczystszym nieb obwodzie
        wypełza chmur gromada -
                parasol noś i przy pogodzie,
        nie tylko gdy deszcz pada.*/
    }
}
