package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectedComponentBFSGraph {

    public static void main(String[] args) {
        List<ArrayList<Integer>> adj = new ArrayList<>();
        int vertex = 9;
        for (int i = 0; i < vertex; i++)
            adj.add(new ArrayList<>());

        // g1
        addEdges(adj, 0, 1);
        addEdges(adj, 0, 2);
        addEdges(adj, 1, 2);

        // g2
        addEdges(adj, 3, 4);

        //g3
        addEdges(adj, 5, 6);
        addEdges(adj, 5, 7);
        addEdges(adj, 7, 8);

        int count = bfsDisconnectComponent(adj, vertex);
        System.out.println("Total disconnected connection : " + count);
    }

    private static int bfsDisconnectComponent(List<ArrayList<Integer>> adj, int vertex) {
        boolean[] visited = new boolean[vertex];
        int count = 0;
        for (int i = 0; i < vertex; i++) {
            if (!visited[i]) {
                bfsDisconnectSearch(adj, i, visited);
                count++;
            }
        }
        return count;
    }

    static void bfsDisconnectSearch(List<ArrayList<Integer>> adj,
                                    int sourceEdge,
                                    boolean[] visited ) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceEdge);
        visited[sourceEdge] = true;

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            //System.out.print(tmp + " ");
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
