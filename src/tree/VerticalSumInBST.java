package tree;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class VerticalSumInBST {

    public static void main(String[] args) {
        /**
         *      10
         *     /  \
         *    20   30
         *   /  \
         *  40   50
         *
         *  O/P - > 20 30
         */
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.right.right = new Node(50);

        verticalMap(root);
    }

    static void verticalMap(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        verticalMapSum(root, 0, map);
        for (Map.Entry entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    private static void verticalMapSum(Node root, int hd, TreeMap<Integer, Integer> map) {
        if (root == null) return;
        verticalMapSum(root.left, hd-1, map);

        int prevSum = map.get(hd) == null ? 0 : map.get(hd);
        map.put(hd, prevSum + root.data);

        verticalMapSum(root.right, hd+1, map);
    }
}
