package tree.gfg.binarytree;

import tree.gfg.Node;

public class MaximumInTree {

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
        root.right = new Node(70);
        root.left.left = new Node(40);
        root.right.right = new Node(90);

        int max = maximumOfTree(root);
        System.out.println("Maximum : " + max);
    }

    private static int maximumOfTree(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            int currentMax = Math.max(maximumOfTree(root.left), maximumOfTree(root.right));
            return Math.max(root.key, currentMax);
        }
    }
}
