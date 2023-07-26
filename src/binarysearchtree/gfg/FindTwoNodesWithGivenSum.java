package binarysearchtree.gfg;

import java.util.HashSet;
import java.util.Set;

public class FindTwoNodesWithGivenSum {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(20);
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(30);
        root.right.right.left = new Node(25);

        int sum=133;

        isPairSumExists(root, sum);
    }

    private static void isPairSumExists(Node root, int sum) {
        Set<Integer> set = new HashSet<>();
        System.out.println("isPairExist : " +  isPairExist(root, sum, set));
    }

    // do inorder traversal
    private static boolean isPairExist(Node root, int sum, Set<Integer> set) {
        if (root == null)
            return false;

        if (isPairExist(root.left, sum, set))
            return true;
        if (set.contains(sum-root.data)) {
            return true;
        } else {
            set.add(root.data);
        }
        return isPairExist(root.right, sum, set);
    }
}
