package tree;

import java.util.LinkedList;
import java.util.Queue;

public class ChildrenSumProperly {

    public static void main(String[] args) {
        /**
         *        50
         *     /     \
         *    20     30
         *   /  \    / \
         *  10   10 20  10
         *
         *  Output -> 10 20 40
         */
        Node root = new Node(50);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(10);
        root.left.right = new Node(10);
/*
        root.right.left = new Node(20);
        root.right.right = new Node(10);
*/

        System.out.println(sumProperly(root));
  }

  static boolean sumProperly(Node root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;

        int sum = 0;
        if (root.left != null) sum = sum + Integer.parseInt(root.left.data.toString());
        if (root.right != null) sum = sum + Integer.parseInt(root.right.data.toString());

        return (Integer.parseInt(root.data.toString()) == sum)
                && (sumProperly(root.left) && sumProperly(root.right));
  }
}
