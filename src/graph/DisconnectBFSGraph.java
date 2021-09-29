package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DisconnectBFSGraph {

    public static void main(String[] args) {
        List<ArrayList<Integer>> adj = new ArrayList<>();
        int vertex = 7;
        for (int i = 0; i < vertex; i++)
            adj.add(new ArrayList<>());

        addEdges(adj, 0, 1);
        addEdges(adj, 0, 2);
        addEdges(adj, 1, 2);
        addEdges(adj, 1, 3);
        addEdges(adj, 2, 3);
        addEdges(adj, 2, 4);
        addEdges(adj, 3, 4);


        bfsDisconnectSearch(adj, vertex);
    }

    private static void bfsDisconnectSearch(List<ArrayList<Integer>> adj, int vertex) {
        boolean[] visited = new boolean[vertex];
        for (int i = 0; i < vertex; i++) {
            if (!visited[i]) {
                bfsDisconnectSearch(adj, i, visited);
            }
        }
    }

    static void bfsDisconnectSearch(List<ArrayList<Integer>> adj,
                                    int sourceEdge,
                                    boolean[] visited ) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceEdge);
        visited[sourceEdge] = true;

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            System.out.print(tmp + " ");
            for (int v : adj.get(tmp)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }

    static void printGraph(List<ArrayList<Integer>> adj) {
        int index = 0;
        for (ArrayList<Integer> edge : adj) {
            System.out.print("Index " + index + ": ");
            for (int ver : edge) {
                System.out.print(ver + " ");
            }
            index++;
            System.out.println();
        }
    }

    static void addEdges(List<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
