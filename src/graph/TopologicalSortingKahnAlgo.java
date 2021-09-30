package graph;

import java.util.*;

public class TopologicalSortingKahnAlgo {

    public static void main(String[] args) {
        int vertex = 5;
        List<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertex; i++)
            adj.add(new ArrayList<>());

        int[] inDegree = new int[vertex];
        addEdge(adj, 0, 2, inDegree);
        addEdge(adj, 0, 3, inDegree);
        addEdge(adj, 2, 3, inDegree);
        addEdge(adj, 1, 3, inDegree);
        addEdge(adj, 1, 4, inDegree);

        System.out.println(Arrays.toString(inDegree));

        topologicalSort(adj, vertex, inDegree);
    }

    private static void topologicalSort(List<ArrayList<Integer>> adj, int vertex, int[] inDegree) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertex; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            System.out.print(tmp + " ");
            for (int v : adj.get(tmp)) {
                inDegree[v] -= 1;
                if (inDegree[v] == 0)
                    queue.add(v);
            }
        }
    }


    static void addEdge(List<ArrayList<Integer>> adj, int u, int v, int[] inDegree) {
        adj.get(u).add(v);
        inDegree[v] += 1;
    }
}
