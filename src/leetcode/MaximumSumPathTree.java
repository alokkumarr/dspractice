package leetcode;

import java.util.Map;

public class MaximumSumPathTree {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return max;
    }

    private int postOrder(TreeNode root) {
        if (root == null) return 0;

        // adding max function if left have -Ve result
        int left = Math.max(postOrder(root.left) , 0);
        int right = Math.max(postOrder(root.right), 0);

        // find the max at every node in final result
        max = Math.max(left, right) + root.val;

        return Math.max(left, right) + root.val;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}

