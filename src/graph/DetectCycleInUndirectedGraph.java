package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInUndirectedGraph {

    public static void main(String[] args) {
        List<ArrayList<Integer>> adj = new ArrayList<>();
        int vertex = 6;
        for (int i = 0; i < vertex; i++)
            adj.add(new ArrayList<>());

        addEdges(adj, 0, 1);
        addEdges(adj, 1, 2);
        addEdges(adj, 1, 3);
        //addEdges(adj, 2, 3);
        addEdges(adj, 2, 4);
        addEdges(adj, 4, 5);

        boolean isCycle = dfsDisconnectedGraph(adj,vertex) ;
        System.out.println("Have cycle in graph : " + isCycle);
    }

    static boolean dfsDisconnectedGraph(List<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                return dfsCycle(adj, i, visited, -1);
            }
        }
        return false;
    }

    private static boolean dfsCycle(List<ArrayList<Integer>> adj, int source, boolean[] visited, int parent) {
        visited[source] = true;
        for (int v : adj.get(source)) {
            if (!visited[v]) {
                return dfsCycle(adj, v, visited, source);
            } else if (parent != v) return true;
        }
        return false;
    }

    static void addEdges(List<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
