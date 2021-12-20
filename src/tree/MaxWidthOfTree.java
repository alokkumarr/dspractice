package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfTree {

    public static void main(String[] args) {
        /*
                 10
              /     \
             20     30
            /  \      \
           40   50    60
          / \   \    / \
         9   7   5  3    70
         */
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.left.left = new Node(9);
        root.left.left.right = new Node(7);
        root.left.right = new Node(50);
        root.left.right.right = new Node(5);
        root.right.right = new Node(60);
        root.right.left = new Node(3);
        root.right.right.right = new Node(70);

        System.out.println("Max width of a tree : " + maxWidthOfTree(root));
    }

    static int maxWidthOfTree(Node root) {
        int res = 0;
        if (root == null) return 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
          int count = q.size();
          for (int i = 0; i < count; count--) {

              res = Math.max(res, q.size());
              Node tmp = q.poll();
              assert tmp != null;

              if (tmp.left != null) q.add(tmp.left);
              if (tmp.right != null) q.add(tmp.right);
          }
        }
        return res;
    }
}
