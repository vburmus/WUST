import java.util.ArrayList;
import java.util.Collections;

public class Graph {

    int vertices;
    int edges;
    ArrayList<Edge> listEdges;

    public Graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        this.listEdges = new ArrayList<>(edges);
    }

    public void addEdge(int firstVertex, int secondVertex, int path) {
        if (this.listEdges.size() < this.edges)
            this.listEdges.add(new Edge(firstVertex, secondVertex, path));
        else
            System.out.println("Blad danych!");
    }
    private Set [] makeSet(int vertices) {
        Set [] table = new Set[vertices];

        for (int i = 0; i < vertices; i++)
            table[i] = new Set(i + 1, 0);

        return table;
    }
    private int findSet(Set [] tabl, int i){
        if (i != tabl[i-1].parent)
            tabl[i-1].parent = findSet(tabl, tabl[i-1].parent);
        return tabl[i-1].parent;
    }
    private void sklejanie(Set [] tabl, int a, int b) {
        int A = findSet(tabl, a);
        int B = findSet(tabl, b);


        if (tabl[A-1].weight>tabl[B-1].weight)
            tabl[B-1].parent = A;
        else if (tabl[A-1].weight<tabl[B-1].weight)
            tabl[A-1].parent = B;
        else{
            tabl[B-1].parent = A;
            tabl[A-1].weight++;
        }
    }

    public void KruskalAlgorithm() {
        Edge [] result = new Edge[this.vertices];
        int COUNTER=0, i=0;
        Collections.sort(this.listEdges);
        System.out.println(this.listEdges);
        Set [] sets = makeSet(this.vertices);

        while (COUNTER < this.vertices-1) {
            Edge act = listEdges.get(i);
            i++;
            int a = findSet(sets, act.getVertex());
            int b = findSet(sets, act.getDestinationVertex());
            if (a != b) {
                result[COUNTER] = act;
                COUNTER++;
                sklejanie(sets, a, b);
            }
        }

        int min = 0;

        for (int j = 0; j < COUNTER; j++) {
            min += result[j].getPathLength();
        }
        System.out.println(min);
    }

}