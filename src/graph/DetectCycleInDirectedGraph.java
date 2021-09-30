package graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraph {

    public static void main(String[] args) {
        List<ArrayList<Integer>> adj = new ArrayList<>();
        int vertex = 6;
        for (int i = 0; i < vertex; i++)
            adj.add(new ArrayList<>());

        addEdges(adj, 0, 1);
        addEdges(adj, 2, 1);

        addEdges(adj, 2, 3);
        addEdges(adj, 3, 4);
        addEdges(adj, 4, 5);
        addEdges(adj, 5, 3);

        //printGraph(adj);

        boolean isCycle = cycleDirectedGraph(adj, vertex) ;
        System.out.println("Have cycle in graph : " + isCycle);
    }

    static boolean cycleDirectedGraph(List<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        boolean[] recursionStack = new boolean[V];
        boolean haveCycle = false;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                haveCycle = dfsCycle(adj, i, visited, recursionStack);
            }
        }
        return haveCycle;
    }

    private static boolean dfsCycle(List<ArrayList<Integer>> adj, int source,
                                    boolean[] visited, boolean[] recStack) {
        visited[source] = true;
        recStack[source] = true;

        for (int v : adj.get(source)) {
            if (!visited[v] && dfsCycle(adj, v, visited, recStack)) {
                return true;
            } else if (recStack[v]) return true;
        }

        recStack[source] = false;
        return false;
    }

    static void addEdges(List<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
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
}
