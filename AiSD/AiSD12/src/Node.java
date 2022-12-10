public class Node {

    int vertex;
    int edge;

    public Node (int vertex, int edge_length) {
        this.vertex = vertex;
        this.edge = edge_length;
    }


    public String toString () {
        return (List.values()[this.vertex] + " [" + this.edge + "]");
    }


    public int getVertex() {
        return vertex;
    }
    public int getEdge() {
        return edge;
    }

}
