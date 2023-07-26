package binarysearchtree.gfg;

import java.util.ArrayList;
import java.util.TreeMap;

public class VerticalSumOfBST {

    /* Time complexity - O(hdlogn)
    *  Space : O(nloghd)
    *                          10 - 0
     *                      /     \
     *                     8 -1   20 +1
     *                   /  \    /  \
     *             -2 4    0 9  11+0 30 +2
     *                              /
     *                             25 +1
     *
     *   O/P - 4 8 19 11
     *
    * */

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(20);
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(30);
        root.right.right.left = new Node(25);

        verticalSumOfBST(root);
    }

    private static void verticalSumOfBST(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        verticleSum(root, 0, map);
        System.out.println(map);
        map.values().forEach(value -> System.out.print(value + " "));
    }


    private static void verticleSum(Node root, int hd, TreeMap<Integer, Integer> map) {
        if (root == null)
            return;

        verticleSum(root.left, hd-1, map);
        int pSum = map.get(hd) == null ? 0 : map.get(hd);
        map.put(hd, pSum+root.data);
        verticleSum(root.right, hd+1, map);
    }
}
