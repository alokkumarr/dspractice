package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphByList {

    /*
        0--------1------2
        \       |
         \      |
          \    |
             3
     */
    public static void main(String[] args) {
        int capacity = 4;
        List<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(capacity);

        for (int i = 0; i < capacity; i++)
            adj.add(new ArrayList<>());

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);

        printGraph(adj);
    }

    static void printGraph(List<ArrayList<Integer>> adj) {
        int index = 0;
        for (List<Integer> vertex : adj) {
            System.out.print("Index " + index + " : ");
            for (Integer data : vertex) {
                System.out.print(data + "  ");
            }
            System.out.println();
            index++;
        }
    }
    static void addEdge(List<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
