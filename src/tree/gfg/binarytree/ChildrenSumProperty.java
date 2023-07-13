package tree.gfg.binarytree;

import tree.gfg.Node;

public class ChildrenSumProperty {
    public static void main(String[] args) {
        /**
         *      50
         *     /  \
         *    20   30
         *   /  \
         *  15   5
         *      /
         *     5
         *
         *  O/P - > 10 20 40 21
         */
        Node root = new Node(50);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(15);
        root.left.right = new Node(5);
        root.left.right.left = new Node(5);

        boolean res = solution(root);
        System.out.println(res);
    }

    private static boolean solution(Node root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;

        int sum = 0;
        if (root.left != null)
            sum += root.left.key;
        if (root.right != null)
            sum += root.right.key;

        return (sum == root.key) && solution(root.left) && solution(root.right);
    }
}
