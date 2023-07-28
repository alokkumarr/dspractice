package graph.gfg;

import java.util.ArrayList;
import java.util.List;

public class GraphWithList {

    /**
     *     0 -- 1 -- 3
     *      \  /
     *        2
     * */
    public static void main(String[] args) {
        int v = 5;
        List<List<Integer>> adj = new ArrayList<>(v);

        for (int i = 0; i<v; i++)
            adj.add(new ArrayList<>());

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);

        printGraph(adj);

    }

    public static void printGraph(List<List<Integer>> adj) {
        for (List<Integer> lists : adj) {
            for (Integer u : lists) {
                System.out.print(u + " ");
            }
            System.out.println();
        }
    }

    private static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
