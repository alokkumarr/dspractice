package tree.gfg.binarytree;

import tree.gfg.Node;

public class ConvertTreeToDoubleLL {
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

        // with the inorder traversal
        Node head = buildDLL(root);

        while (head != null) {
            System.out.print(head.key + " ");
            head = head.right;
        }

    }

    static Node prev = null;
    private static Node buildDLL(Node root) {
        if (root == null) return root;

        Node head = buildDLL(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        buildDLL(root.right);
        return head;
    }
}
