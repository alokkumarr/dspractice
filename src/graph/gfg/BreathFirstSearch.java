package graph.gfg;

import java.util.*;

public class BreathFirstSearch {

    public static void main(String[] args) {
        int V = 7;
        List<List<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        /**              1
         *           /   |
         *         0    |
         *          \  |
         *            2
         *
        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,2);
        addEdge(adj,2,3);
        addEdge(adj,1,3);
        addEdge(adj,3,4);
        addEdge(adj,2,4);
         System.out.println("Following is Breadth First Traversal: ");
         BFS(adj,V,0);

         */

        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,2,3);
        addEdge(adj,1,3);
        addEdge(adj,4,5);
        addEdge(adj,5,6);
        addEdge(adj,4,6);

        System.out.print("Number of islands: "+numberOfIsland(adj,V));
    }

    private static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    private static int numberOfIsland(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V+1];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                disconnetBFS(adj, i, visited);
            }
        }
        System.out.println();
        return count;
    }

    public static void bfsDisconnected(List<List<Integer>> adj, int V, int s) {
        boolean[] visited = new boolean[V+1];
        for (int i = 0; i <= V; i++) {
            if (!visited[i]) {
                disconnetBFS(adj, i, visited);
            }
        }
    }

    // disconnected graph
    public static void disconnetBFS(List<List<Integer>> adj, int s, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
    }


        // solve by level order traversal (connected graph)
    public static void BFS(List<List<Integer>> adj, int V, int s) {
        boolean[] visited = new boolean[V+1];

        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
    }
}
