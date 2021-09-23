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
         *  10   1 20  10
         *
         */
        Node root = new Node(50);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(10);
        root.left.right = new Node(10);
        root.right.left = new Node(20);
        root.right.right = new Node(1);

        System.out.println(sumProperly(root));
  }

  static boolean sumProperly(Node root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;

        int sum = 0;
        if (root.left != null) {
            sum = sum + root.left.data;
        }
        if (root.right != null) {
            sum = sum + root.right.data;
        }

        return (root.data == sum)
                && (sumProperly(root.left) && sumProperly(root.right));
  }
}
