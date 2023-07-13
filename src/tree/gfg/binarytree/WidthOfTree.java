package tree.gfg.binarytree;

import tree.gfg.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A tree is balanced iff the difference
 * of left and right subtree is 0 or 1.
 */
public class WidthOfTree {

    public static void main(String[] args) {
        /**
         *      10
         *     /  \
         *    20   30
         *   /  \    \
         *  40   50   44
         *      /
         *     21
         *
         *  O/P - > 3
         */
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.right.left = new Node(21);

        root.right.right = new Node(44);

        int res = widthTree(root);
        System.out.println("Width Tree : " + res);
    }


    private static int widthTree(Node root) {
        if (root == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int res = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int count = queue.size();
            res = Math.max(count, res);
            for (int i = 0; i < count; i++) {
                Node tmp = queue.poll();

                if (tmp != null && tmp.left != null)
                    queue.add(tmp.left);
                if (tmp != null && tmp.right != null)
                    queue.add(tmp.right);
            }
        }
        return res;
    }
}
