public class Graph {

    private OneWayLinkedListWithHead<Node> [] listaSasiedctwa;

    public Graph(int size) {
        this.listaSasiedctwa = new OneWayLinkedListWithHead[size];
        for (int i = 0; i < size; i++) {
            this.listaSasiedctwa[i] = new OneWayLinkedListWithHead<>();
        }
    }

    public void addEdge(int a, int b, int length)
    {
        this.getListaSasiedctwa()[a].add(new Node(b, length));
    }

    public void showListe() {
        System.out.println("Lista sąsiedztwa: \n{");

        for (int i = 0; i < this.getListaSasiedctwa().length; i++) {
            System.out.print(List.values()[i]);
            if (this.getListaSasiedctwa()[i].isEmpty())
                System.out.print(" ->");
            else {
                for (Node node : this.getListaSasiedctwa()[i])
                    System.out.print(" -> " + node.toString());
            }
            System.out.print("\n");
        }
        System.out.println("}\n\n");
    }

    private int min(int [] road, boolean [] vis) {
        int min = Integer.MAX_VALUE;
        int ind_min = -1;

        for (int i=0; i < road.length; i++) {
            if (!vis[i] && road[i] <= min) {
                min = road[i];
                ind_min = i;
            }
        }
        return ind_min;
    }

    public void djikstra(String m) {
        int listSize = this.getListaSasiedctwa().length;
        int [] road = new int [listSize];
        boolean [] vis = new boolean [listSize];
        try {
           int a = List.valueOf(m).ordinal();
            OneWayLinkedListWithHead<Node> list = this.getListaSasiedctwa()[a];
            for (int i = 0; i < listSize; i++) {
                if (i == a) {
                    road[i] = 0;
                    vis[i] = true;
                }
                else {
                    road[i] = Integer.MAX_VALUE;
                    for (Node node : list) {
                        if (node.getVertex() == i) {
                            road[i] = node.getEdge();
                            break;
                        }
                    }
                    vis[i] = false;
                }
            }

            for (int i = 0; i < listSize-1; i++) {
                int next = min(road, vis);
                vis[next] = true;

                OneWayLinkedListWithHead<Node> listaElementu = this.getListaSasiedctwa()[next];

                for (Node node : listaElementu){
                    if (road[next] != Integer.MAX_VALUE && road[next] + node.getEdge() < road[node.getVertex()])
                        road[node.getVertex()] = road[next] + node.getEdge();
                }
            }
            System.out.println("\nNajkrótsze drógi:\n{");

            for (int i = 0; i < road.length; i++) {
                if (road[i] != 0) {
                    System.out.print(List.values()[i] + " - " + road[i] + ", ");

                }
            }
            System.out.println("\n}\n\n");
        }catch (IllegalArgumentException e){
            System.out.println("Nieprawidlowe miasto");
        }

    }

    private void dfs(int a, boolean [] visited) {
        visited[a] = true;
        System.out.print(List.values()[a] + " ");
        for (Node node : this.getListaSasiedctwa()[a]) {
            if (!visited[node.getVertex()])
                dfs(node.getVertex(), visited);
        }
    }

    public void DFS(String m) {
        try {
            boolean [] visElements = new boolean [this.getListaSasiedctwa().length];
            System.out.println("DFS:");
            dfs(List.valueOf(m).ordinal(), visElements);
        }catch (IllegalArgumentException e){
            System.out.println("Nieprawidlowe miasto");
        }
        }

    public OneWayLinkedListWithHead<Node>[] getListaSasiedctwa() {
        return listaSasiedctwa;
    }

}
