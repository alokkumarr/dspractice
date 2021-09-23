package tree;

import java.util.Stack;

public class TreeTraversalIterative {
    public static void main(String[] args) {
        /**
         *        10
         *     /     \
         *    20     30
         *   /  \    / \
         *  40   50 60  70
         *
         *  Output -> 40 20 50 10 60 30 70
         */
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        inOrderTraversal(root);
        System.out.println("------------------------");
        preOrderTraversal(root);
        System.out.println("------------------------");
        postOrderTraversal(root);
    }

    // time  - O(n) - every node visited once and stores in stack
    // space O(h)
    private static void inOrderTraversal(Node root) {
        Stack<Node> st = new Stack<>();
        Node cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            System.out.print(cur.data + " ");
            cur = cur.right;
        }
    }

    private static void postOrderTraversal(Node root) {

    }

    // O(n)
    private static void preOrderTraversal(Node root) {
        if (root == null) return;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            Node cur = st.pop();
            System.out.print(cur.data + " ");
            if (cur.right != null) st.push(cur.right);
            if (cur.left != null) st.push(cur.left);
        }
    }
}
