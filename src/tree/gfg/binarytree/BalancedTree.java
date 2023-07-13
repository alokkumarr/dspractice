package tree.gfg.binarytree;

import tree.gfg.Node;

/**
 * A tree is balanced iff the difference of left and right subtree is 0 or 1.
 */
public class BalancedTree {

    public static void main(String[] args) {
        /**
         *      10
         *     /  \
         *    20   30
         *   /  \
         *  40   50
         *      /
         *     21
         *
         *  O/P - > 10 20 40 21
         */
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(70);
        root.left.left = new Node(40);
        root.right.right = new Node(90);
        root.right.right.left = new Node(21);

        int res = isTreeBalanced(root);
        System.out.println("Tree Balanced : " + (res == 1 || res == 0));
    }

    private static int isTreeBalanced(Node root) {
        if (root == null)
            return 0;

        int lh = isTreeBalanced(root.left);
        if (lh == -1) return -1;

        int rh = isTreeBalanced(root.right);
        if (rh == -1) return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;
        else
            return Math.max(lh, rh) + 1;
    }
}
