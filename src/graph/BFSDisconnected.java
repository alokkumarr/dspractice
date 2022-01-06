package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSDisconnected {

    void bfs(List<List<Integer>> adj, int s, boolean[] visited) {
        // build queue for traversing
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.offer(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }

    void bfsDisconnected(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V + 1];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                bfs(adj, i, visited);

        }
    }
}
