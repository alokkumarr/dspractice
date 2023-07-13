package tree.gfg.binarytree;

import tree.gfg.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversalSpiralForm {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.right.left = new Node(88);
        root.right.left = new Node(60);
        root.right.left.right = new Node(56);
        root.right.right = new Node(70);

        /*
         *                 10
         *                /   \
         *              20     30
         *             /  \    / \
         *            40   50 60  70
         *                /    \
         *              88     56
         *
         *  O/P -> 10 30 20 40 50 60 70 56 88
         */


        spiralTraversalWithTwoStack(root);
    }

    private static void spiralTraversalWithTwoStack(Node root) {
        if (root == null) return;

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(root);

        while (!st1.isEmpty()) {

            while (!st1.isEmpty()) {
                Node tmp = st1.pop();
                System.out.print(tmp.key + " ");
                if (tmp.left != null)
                    st2.push(tmp.left);
                if (tmp.right != null)
                    st2.push(tmp.right);
            }

            while (!st2.isEmpty()) {
                Node tmp = st2.pop();
                System.out.print(tmp.key + " ");
                if (tmp.right != null)
                    st1.push(tmp.right);
                if (tmp.left != null)
                    st1.push(tmp.left);
            }
        }

    }

    private static void spiralTraversalWithOneStackAndQueue(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Stack<Node> st = new Stack<>();
        boolean reverse = false;

        while (!q.isEmpty()) {

            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node tmp = q.poll();
                if (reverse) {
                    st.push(tmp);
                } else {
                    assert tmp != null;
                    System.out.print(tmp.key + " ");
                }

                assert tmp != null;
                if (tmp.left != null) q.add(tmp.left);
                if (tmp.right != null) q.add(tmp.right);
            }

            if (reverse) {
                while (!st.isEmpty()) {
                    Node tmp = st.pop();
                    System.out.print(tmp.key + " ");
                }
            }
            // this flag will false for root node, once 1st level print then update
            reverse = !reverse;
        }
    }
}
