package graph.gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class AdjListNode
{
    private int v;
    private int weight;

    AdjListNode(int _v, int _w) {
        v = _v;
        weight = _w;
    }
    int getV() { return v; }
    int getWeight() { return weight; }
}

public class ShortestPathDAG {

    public static void main(String[] args) {
        int V = 6;
        List<List<AdjListNode>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        addEdge(adj,0, 1, 2);
        addEdge(adj,0, 4, 1);
        addEdge(adj, 1,2, 3);
        addEdge(adj, 4, 2, 2);
        addEdge(adj,4, 5, 4);
        addEdge(adj,2, 3, 6);
        addEdge(adj,5, 3, 1);

        shortestPath(adj, 0, V);
    }

    private static void shortestPath(List<List<AdjListNode>> adj, int s, int V) {
        Stack<Integer> stack = topologicalSort(adj, V);
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[s] = 0;

        while (!stack.isEmpty()) {
            int u = stack.pop();
            for(AdjListNode v : adj.get(u)) {
                if (distance[v.getV()] > distance[u] + v.getWeight()) {
                    distance[v.getV()] =  distance[u] + v.getWeight();
                }
            }
        }

        System.out.println("Distance from source : " + Arrays.toString(distance));

    }


    public static Stack<Integer> topologicalSort(List<List<AdjListNode>> adj, int V) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsRec(adj, i, stack, visited);
            }
        }

        System.out.println(stack);
        return stack;
    }

    private static void dfsRec(List<List<AdjListNode>> adj, int v, Stack<Integer> stack, boolean[] visited) {
        visited[v] = true;
        for (AdjListNode u : adj.get(v)) {
            if (!visited[u.getV()]) {
                dfsRec(adj, u.getV(), stack, visited);
            }
        }
        stack.push(v);
    }


    static void addEdge(List<List<AdjListNode>> adj, int u, int v, int weight) {
        AdjListNode node = new AdjListNode(v, weight);
        adj.get(u).add(node);
    }
}
