package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewOfTree {

    public static void main(String[] args) {
        /**
         *        10
         *     /     \
         *    20     30
         *   /  \    / \
         *  40   50 60  70
         *
         *  Output -> 10 20 40
         */
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        int level = 1;
        leftViewOfTree(root);

        System.out.println(leftViewOfTree(root));
    }

    static ArrayList<Integer> leftViewOfTree(Node root) {
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // number of nodes at current level
            int n = queue.size();

            // Traverse all nodes of current level
            for (int i = 0; i < n; ) {
                Node temp = queue.poll();
                if (i == 0)
                    res.add(temp.data);
                assert temp != null;
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
                i++;
            }
        }
        return res;
    }

    /**
     * Maintains the max level and print only iff maxLevel < level
     */
    static int maxLevel = 0;
    static void leftViewOfTree(Node root, int level) {
        if (root == null) return;

        if (maxLevel < level) {
            System.out.print(root.data + " ");
        }
        maxLevel++;
        leftViewOfTree(root.left, level+1);
        leftViewOfTree(root.right, level+1);
    }
}
