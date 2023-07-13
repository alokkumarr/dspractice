package tree.gfg.binarytree;

import tree.gfg.Node;

public class HeightTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        /**
         *                 10
         *                /   \
         *              20     30
         *             /  \    / \
         *            40   50 60  70
         */

        int height = height(root);
        System.out.println("Height : " + height);
        int size = getSize(root);
        System.out.println("Size : " + size);

    }

    private static int getSize(Node root) {
        if (root == null) return 0;
        else
            return  1 + getSize(root.left) + getSize(root.right);
    }

    private static int height(Node root) {
        if (root == null)
            return 0;
        else
            return 1+ Math.max(height(root.left), height(root.right));

    }
}
