package graph;

import java.util.*;

public class TopologicalSortingByDFS {

    public static void main(String[] args) {
        int vertex = 5;
        List<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertex; i++)
            adj.add(new ArrayList<>());

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);

        topologicalSort(adj, vertex);
    }

    private static void topologicalSort(List<ArrayList<Integer>> adj, int vertex) {
        boolean[] visited = new boolean[vertex];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < vertex; i++) {
            if (!visited[i]) {
                dfsRecursion(adj, i, visited, stack);
            }
        }
        while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
    }

    private static void dfsRecursion(List<ArrayList<Integer>> adj, int sourceVertex,
                                     boolean[] visited, Stack<Integer> stack) {
        visited[sourceVertex] = true;
        for (int v : adj.get(sourceVertex)) {
            if (!visited[v]) {
                dfsRecursion(adj, v, visited, stack);
            }
        }
        stack.add(sourceVertex);
    }

    static void addEdge(List<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }
}
