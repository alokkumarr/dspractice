package graph.gfg;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleUnweightedGraph {
    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,3);
        //addEdge(adj,1,2);
        addEdge(adj,2,3);

        boolean findCycle = findCycle(adj, V);
        System.out.println("Find Cycle : " + findCycle );
    }

    private static boolean findCycle(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V+1];
        int parent = -1;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if(dfsRec(adj, i, visited, parent))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfsRec(List<List<Integer>> adj, int s, boolean[] visited, int parent) {
        visited[s] = true;
        for (int u : adj.get(s)) {
            if (!visited[u]) {
                if (dfsRec(adj, u, visited, s))
                    return true;
            } else if(u != parent)
                return true;
        }
        return false;
    }

    private static void addEdge(List<List<Integer>> adj, int v, int u) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }


}
