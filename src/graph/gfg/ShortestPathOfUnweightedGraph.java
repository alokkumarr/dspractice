package graph.gfg;

import java.util.*;

public class ShortestPathOfUnweightedGraph {
    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,3);
        addEdge(adj,1,2);
        addEdge(adj,2,3);

        sortestPath(adj, V, 0);

    }

    private static void sortestPath(List<List<Integer>> adj, int V, int s) {
        boolean[] visited = new boolean[V+1];

        int[] distance = new int[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        distance[s] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    distance[v] = distance[u] + 1;
                    queue.add(v);
                }
            }
        }

        for (int element : distance) {
            if (element != Integer.MAX_VALUE) {
                System.out.print(element + " ");
            }
        }
    }

    private static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
