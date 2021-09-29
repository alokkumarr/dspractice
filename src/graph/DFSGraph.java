package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFSGraph {

    public static void main(String[] args) {
        List<ArrayList<Integer>> adj = new ArrayList<>();
        int vertex = 5;
        for (int i = 0; i < vertex; i++)
            adj.add(new ArrayList<>());

        addEdges(adj, 0, 1);
        addEdges(adj, 0, 2);
        addEdges(adj, 1, 2);
        // disconnected this graph by comment
        //addEdges(adj, 1, 3);
        //addEdges(adj, 1, 4);
        //addEdges(adj, 2, 3);
        addEdges(adj, 3, 4);

        int sourceEdge = 0;
        dfsGraph(adj, sourceEdge, vertex);
        System.out.println("\n---------");
        dfsDisconnectedGraph(adj, sourceEdge, vertex);
    }

    static void dfsDisconnectedGraph(List<ArrayList<Integer>> adj, int sourceEdge, int V) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfsRecursion(adj, i, visited);
        }
    }

    static void dfsGraph(List<ArrayList<Integer>> adj, int sourceEdge, int V) {
        boolean[] visited = new boolean[V];
        dfsRecursion(adj, sourceEdge, visited);
    }

    private static void dfsRecursion(List<ArrayList<Integer>> adj, int sourceEdge, boolean[] visited) {
        visited[sourceEdge] = true;
        System.out.print(sourceEdge + " ");
        for (int v : adj.get(sourceEdge)) {
            if (!visited[v]) dfsRecursion(adj, v, visited);
        }
    }





    static void bfsSearch(List<ArrayList<Integer>> adj, int sourceEdge, int V) {
        boolean[] visited = new boolean[V];
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

    static void addEdges(List<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
