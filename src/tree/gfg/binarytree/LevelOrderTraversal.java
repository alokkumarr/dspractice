package tree.gfg.binarytree;

import tree.gfg.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        /**
         *      10
         *     /  \
         *    20   30
         *   /  \
         *  40   50
         *
         *  O/P - > 20 30
         */
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        levelOrder(root);
        System.out.println();
        System.out.println("--------------------");
        levelOrderLineByLineSolution1(root);
        System.out.println();
        System.out.println("--------------------");
        levelOrderLineByLineSolution2(root);
    }

    private static void levelOrderLineByLineSolution2(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // white solution with two loop,
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node temp = queue.poll();

                assert temp != null;
                System.out.print(temp.key + " ");
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            System.out.println();
        }
    }


    private static void levelOrderLineByLineSolution1(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); //  for every level add one null in to queue

        while (queue.size() > 1) { // in the end queue will have one null item so check will be on size
            Node temp = queue.poll();

            if (temp == null) {
                System.out.println();
                queue.add(null);
            } else {
                System.out.print(temp.key + " ");
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }
    }

    private static void levelOrder(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            System.out.print(temp.key + " ");

            if (temp.left != null)
                queue.add(temp.left);

            if (temp.right != null)
                queue.add(temp.right);

        }


    }
}
