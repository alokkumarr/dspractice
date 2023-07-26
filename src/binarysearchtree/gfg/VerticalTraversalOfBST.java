package binarysearchtree.gfg;

import java.util.ArrayList;
import java.util.TreeMap;

public class VerticalTraversalOfBST {

    /* Time complexity - O(hdlogn)
    *  Space : O(nloghd)
    *
    *                        10
    *                      /     \
    *                     8      20
    *                   /  \    /  \
    *                  4    9  11   30
    *                              /
    *                             25
    */
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(20);
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(30);
        root.right.right.left = new Node(25);

        verticalTraversalOfBST(root);
    }

    private static void verticalTraversalOfBST(Node root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        verticleSum(root, 0, map);
        System.out.println(map);
        map.values().forEach(value -> System.out.println(value));// value.forEach(v -> System.out.print(v + " ")));
    }


    private static void verticleSum(Node root, int hd, TreeMap<Integer, ArrayList<Integer>> map) {
        if (root == null)
            return;

        if (map.containsKey(hd)) {
            ArrayList<Integer> al = map.get(hd);
            al.add(root.data);
            map.put(hd, al);
        } else {
            ArrayList<Integer> al =new ArrayList<>();
            al.add(root.data);
            map.put(hd, al);
        }
        verticleSum(root.left, hd-1, map);
        verticleSum(root.right, hd+1, map);
    }
}
