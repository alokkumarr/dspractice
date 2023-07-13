package tree.gfg.binarytree;

import tree.gfg.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftViewOfBT {
    public static void main(String[] args) {
        /**
         *      10
         *     /  \
         *    20   70
         *   /  \
         *  40   90
         *      /
         *     21
         *      \
         *       87
         *  O/P - > 10 20 40 21
         */
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(70);
        root.left.left = new Node(40);
        root.right.right = new Node(90);
        root.right.right.left = new Node(21);
        root.right.right.left.right = new Node(87);

        printLeftView(root);
    }

    private static void printLeftView(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node tmp = q.poll();

                if (i == 0) {
                    System.out.print(tmp.key + " ");
                }

                assert tmp != null;
                if (tmp.left != null) q.add(tmp.left);
                if (tmp.right != null) q.add(tmp.right);

            }
        }
    }
}
