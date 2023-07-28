package graph.gfg;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    public static void main(String[] args) {
        int V = 7;

        List<List<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,2,3);
        addEdge(adj,1,3);
        addEdge(adj,1,4);
        addEdge(adj,3,4);

        addEdge(adj,5,6);

        DFS(adj, V, 0);
        System.out.println();

        dfsDisconnected(adj, V);
        System.out.println();

        System.out.println("Number of island : " + numberOfIsland(adj, V));
    }


    private static int numberOfIsland(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V+1];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                dfsRec(adj, i, visited);
            }
        }
        return count;
    }

    private static void dfsDisconnected(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V+1];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsRec(adj, i, visited);
            }
        }
    }

    private static void DFS(List<List<Integer>> adj, int V, int s) {
        boolean[] visited = new boolean[V+1];
        dfsRec(adj, s, visited);
    }

    private static void dfsRec(List<List<Integer>> adj, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");

        for (int u : adj.get(s)) {
            if (!visited[u]) {
                dfsRec(adj, u, visited);
            }
        }
    }

    private static void addEdge(List<List<Integer>> adj, int v, int u) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
