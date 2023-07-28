package graph.gfg;

import java.util.*;

public class TopologicalSortingByDFS {

    public static void main(String[] args) {
        int V = 5;
        List<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        addEdge(adj,0, 1);
        addEdge(adj,1, 3);
        addEdge(adj,2, 3);
        addEdge(adj,3, 4);
        addEdge(adj,2, 4);

        System.out.println(Arrays.toString(topologicalSort(adj, V)));
    }

    public static int[] topologicalSort(List<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsRec(adj, i, stack, visited);
            }
        }

        System.out.println(stack);
        int[] arr = new int[V];
        int i = 0;
        while (!stack.empty()) {
            arr[i] = stack.pop();
            i++;
        }
        return arr;
    }

    private static void dfsRec(List<ArrayList<Integer>> adj, int v, Stack<Integer> stack, boolean[] visited) {
        visited[v] = true;
        for (int u : adj.get(v)) {
            if (!visited[u]) {
                dfsRec(adj, u, stack, visited);
            }
        }
        stack.push(v);
    }


    static void addEdge(List<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }
}
