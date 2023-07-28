package graph.gfg;

import java.util.*;

public class DetectCycleByTopologicalSort {

    public static void main(String[] args) {
        int V = 5;
        List<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        int[] inDegree = new int[V];
        addEdge(adj, 0, 2, inDegree);
        addEdge(adj, 0, 3, inDegree);
        addEdge(adj, 3, 0, inDegree);
        addEdge(adj, 1, 3, inDegree);
        addEdge(adj, 1, 4, inDegree);

        System.out.println(Arrays.toString(inDegree));

        boolean haveCycle = cycleByTopologicalSort(adj, V, inDegree);
        System.out.println();
        System.out.println("haveCycle : " + haveCycle);
    }

    private static boolean cycleByTopologicalSort(List<ArrayList<Integer>> adj, int V, int[] inDegree) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            System.out.print(tmp + " ");
            for (int v : adj.get(tmp)) {
                inDegree[v] -= 1;
                if (inDegree[v] == 0)
                    queue.add(v);
            }
            count++;
        }

        return count != V;
    }


    static void addEdge(List<ArrayList<Integer>> adj, int u, int v, int[] inDegree) {
        adj.get(u).add(v);
        inDegree[v] += 1;
    }
}
