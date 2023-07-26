package binarysearchtree.gfg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBST {

    /* Time complexity - O(hdlogn)
    *  Space : O(nloghd)
    *
    *                          10
    *                      /      \
    *                     20      50
    *                   /  \     /  \
    *                 30    40  60  70
    *
    * O/P - 30 20 60 50 70
    */
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(50);
        root.left.left = new Node(30);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        bstBottomView(root);
        System.out.println();
        System.out.println("By Level Order traversal");
        bstViewByLevelOrder(root);
    }

    private static void bstViewByLevelOrder(Node root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        while (!q.isEmpty()) {
            Pair p=q.poll();
            Node curr=p.node;
            int hd=p.hd;

            // build a map if key is not present
            mp.put(hd, curr.data);

            if(curr.left!=null)
                q.add(new Pair(curr.left,hd-1));
            if(curr.right!=null)
                q.add(new Pair(curr.right,hd+1));
        }

        mp.values().forEach(v -> System.out.print(v + " "));

    }


    private static void bstBottomView(Node root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        bstViewTopAndBottom(root, 0, map);
        System.out.println(map);
        System.out.println("Bottom View :");
        map.values().forEach(value -> System.out.print(value.get(value.size()-1) + " "));// value.forEach(v -> System.out.print(v + " ")));
    }

private static void bstViewTopAndBottom(Node root, int hd, TreeMap<Integer, ArrayList<Integer>> map) {
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
        bstViewTopAndBottom(root.left, hd-1, map);
        bstViewTopAndBottom(root.right, hd+1, map);
    }
}