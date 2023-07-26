package tree.gfg.binarytree;

import tree.gfg.Node;

public class IterativeTraversal {

    public static void main(String[] args) {
        /*
         *      10
         *     /  \
         *    20   70
         *   /  \
         *  40   90
         *      /
         *     21
         *      \
         *       87
         *
         *  O/P Serialized - > {10, 20, 40, -1, -1, 90, 21, -1, 87, -1, -1, -1, 70, -1, -1}
         *
         *  Deserialized : 10 20 40 90 21 87 70
         *
         */
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(70);
        root.left.left = new Node(40);
        root.left.right = new Node(90);
        root.left.right.left = new Node(21);
        root.left.right.left.right = new Node(87);
    }
}
