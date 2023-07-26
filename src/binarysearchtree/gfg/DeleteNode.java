package binarysearchtree.gfg;

import binarysearchtree.BinarySearchTree;
import binarysearchtree.Node;

public class DeleteNode {
    /*
              A tree is balanced when its left or right tree diff is 0 or 1.
                     15
                   /    \
                 5       20
                /       /  \
               3      18    80
                     /
                    16
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
        deleteBSTNode(root, 20);
        System.out.println();
        BinarySearchTree.traverse(root);

        deleteBSTNode(root, 15);
        System.out.println();
        BinarySearchTree.traverse(root);

    }

    static Node deleteBSTNode(Node root, int k) {
        if (root == null)
            return null;

        if (k < root.data) {
            root.left = deleteBSTNode(root.left, k);
        } else if (k > root.data) {
            root.right = deleteBSTNode(root.right, k);
        } else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                Node succ = getSuccessor(root);
                root.data = succ.data;
                root.right = deleteBSTNode(root.right, succ.data);
            }
        }
        return root;
    }

    private static Node getSuccessor(Node root) {
        Node curr = root.right;
        while (curr != null && curr.left != null)
            curr = curr.left;

        return curr;
    }
}
