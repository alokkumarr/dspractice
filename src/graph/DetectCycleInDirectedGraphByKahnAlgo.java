package graph;

import java.util.*;

public class DetectCycleInDirectedGraphByKahnAlgo {

    public static void main(String[] args) {
        int vertex = 5;
        List<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertex; i++)
            adj.add(new ArrayList<>());

        int[] inDegree = new int[vertex];
        addEdge(adj, 0, 1, inDegree);
        addEdge(adj, 1, 2, inDegree);
        addEdge(adj, 2, 3, inDegree);
        addEdge(adj, 3, 1, inDegree);
        addEdge(adj, 4, 1, inDegree);

        System.out.println("inDegree : " + Arrays.toString(inDegree));

        boolean hasCycle = detectCycle(adj, vertex, inDegree);
        System.out.println("Has Cycle : " + hasCycle);
    }

    private static boolean detectCycle(List<ArrayList<Integer>> adj, int vertex, int[] inDegree) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertex; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            //  System.out.print(tmp + " ");
            for (int v : adj.get(tmp)) {
                inDegree[v] -= 1;
                if (inDegree[v] == 0)
                    queue.add(v);
            }
            count++;
        }
        return count != vertex;
    }


    static void addEdge(List<ArrayList<Integer>> adj, int u, int v, int[] inDegree) {
        adj.get(u).add(v);
        inDegree[v] += 1;
    }
}
