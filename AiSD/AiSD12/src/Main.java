import java.util.HashMap;
import java.util.Hashtable;

public class Main {
    public static Graph make(){
        Graph graf = new Graph(5);
        graf.addEdge(0, 1, 10);
        graf.addEdge(0, 3, 30);
        graf.addEdge(0, 4, 100);
        graf.addEdge(1, 2, 50);
        graf.addEdge(2, 4, 10);
        graf.addEdge(3, 2, 20);
        graf.addEdge(3, 4, 60);
        return graf;
    }
    public static void main (String [] args) {
        Hashtable<Integer,String> m = new Hashtable<>();
        m.put(1,"B");
        m.put(3,"B");
        m.put(2,"B");
        m.put(0,"B");
        System.out.println(m.get("A"));
        System.out.println(m);
        HashMap<String,String> n =  new HashMap<>();
        System.out.println(n.getClass().getSuperclass().getSuperclass());
        /*Graph graf = make();
        graf.showListe();
        String miasto = "Wrocław";
        graf.djikstra(miasto);
        graf.DFS(miasto);*/
    }
}
