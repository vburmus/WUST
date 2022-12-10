public class Edge implements Comparable<Edge>{

    private int vertex;
    private int destinationVertex;
    private int pathLength;

    public Edge(int vertex, int dest, int edge_length){
        this.vertex = vertex;
        this.destinationVertex = dest;
        this.pathLength = edge_length;
    }

    public String toString()
    {
        return (this.vertex + " <-> " + this.destinationVertex + ": " + this.pathLength);
    }

    public int getVertex() {
        return vertex;
    }

    public int getDestinationVertex() {
        return destinationVertex;
    }

    public int getPathLength() {
        return pathLength;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.pathLength - edge.pathLength;
    }
}
