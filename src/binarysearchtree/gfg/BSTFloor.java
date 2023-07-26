package binarysearchtree.gfg;

import binarysearchtree.BinarySearchTree;
import binarysearchtree.Node;

public class BSTFloor {

    /**
     * Floor of the three is the closest smallest element of the key.
     *
     *                      15
     *                    /    \
     *                  5       20
     *                 /       /  \
     *                3      18    80
     *                      /
     *                     16
     */

    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.right.left = new Node(18);
        root.right.right = new Node(80);
        root.right.left.left = new Node(16);

        BinarySearchTree.traverse(root);
        System.out.println();
        Node floor = findFloor(root, 13);
        System.out.println(floor);
    }

    private static Node findFloor(Node root, int key) {
        Node res = null;

        while (root != null) {
            if (root.data == key)
                return root;
            if (root.data > key)
                root = root.left;
            else {
                res = root;
                root = root.right;
            }
        }

        return res;
    }
}
