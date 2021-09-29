package graph;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class ShortestPathUnweightedBFSGraph {

    public static void main(String[] args) {
        List<ArrayList<Integer>> adj = new ArrayList<>();
        int vertex = 4;
        for (int i = 0; i < vertex; i++)
            adj.add(new ArrayList<>());

        addEdges(adj, 0, 1);
        addEdges(adj, 0, 2);
        addEdges(adj, 1, 2);
        addEdges(adj, 1, 3);
        addEdges(adj, 2, 3);

        int sourceEdge = 0;
        shortestPath(adj, sourceEdge, vertex);
    }

    static void shortestPath(List<ArrayList<Integer>> adj, int sourceEdge, int V) {
        int[] dis = new int[V];
        for (int i : dis) dis[i] = Integer.MAX_VALUE;
        dis[sourceEdge] = 0;

        boolean[] visited = new boolean[V];
        visited[sourceEdge] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceEdge);

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            //System.out.print(tmp + " ");
            for (int v : adj.get(tmp)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                    dis[v] = dis[tmp] + 1;
                }
            }
        }
        System.out.println("Distance from 0 to every node :" + Arrays.toString(dis));
    }

    static void addEdges(List<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
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
