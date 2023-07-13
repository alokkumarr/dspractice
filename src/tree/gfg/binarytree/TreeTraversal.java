package tree.gfg.binarytree;

import tree.gfg.Node;

public class TreeTraversal {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        /*
         *                 10
         *                /   \
         *              20     30
         *             /  \    / \
         *            40   50 60  70
         */
        System.out.print("InOrder (L -> Root -> R) : ");
        inOrderTraversal(root);
        System.out.println();
        System.out.print("PreOrder (Root -> L -> R) : ");
        preOrderTraversal(root);
        System.out.println();
        System.out.print("PostOrder (L -> R -> Root) : ");
        postOrderTraversal(root);
    }

    public static void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.key + " ");
        }
    }

    public static void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.key + " ");
            inOrderTraversal(root.right);
        }
    }
}
