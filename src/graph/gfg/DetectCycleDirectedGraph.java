package graph.gfg;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDirectedGraph {
    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        addEdge(adj,0,1);
        addEdge(adj,2,1);
        addEdge(adj,2,3);
        addEdge(adj,3,4);
        addEdge(adj,4,5);
        addEdge(adj,5,3);

        boolean findCycle = findCycle(adj, V);
        System.out.println("Find Cycle : " + findCycle );
    }

    private static boolean findCycle(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V+1];
        boolean[] recStack = new boolean[V+1];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if(dfsRec(adj, i, visited, recStack))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfsRec(List<List<Integer>> adj, int s, boolean[] visited, boolean[] recStack) {
        visited[s] = true;
        recStack[s] = true;
        for (int u : adj.get(s)) {
            if (!visited[u] && dfsRec(adj, u, visited, recStack)) {
                    return true;
            } else if(recStack[u])
                return true;
        }
        recStack[s] = false;
        return false;
    }

    private static void addEdge(List<List<Integer>> adj, int v, int u) {
        adj.get(u).add(v);
        //adj.get(v).add(u);
    }


}
