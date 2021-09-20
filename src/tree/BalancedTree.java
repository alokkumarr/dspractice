package tree;

public class BalancedTree {

    public static void main(String[] args) {
        /*
          A tree is balanced when its left or right tree diff is 0 or 1.

                 3
              /     \
             4       8
            /  \      \
           5   9       7
          /
         10
           \
            3
         */
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(5);
        root.left.right = new Node(9);
        root.right.right = new Node(7);
        root.left.left.left = new Node(10);
        root.left.left.left.right = new Node(3);

        boolean have = isTreeBalancedBest(root) >= 0;
        System.out.println("isTreeBalanced : " +  have);
  }

    // O(n)
    static int isTreeBalancedBest(Node root) {
        if (root == null) return 0;

        int lh = isTreeBalancedBest(root.left);
        if (lh == -1) return -1;
        int rh = isTreeBalancedBest(root.right);
        if (rh == -1) return -1;

        if (Math.abs(lh-rh) > 1) return -1;
        else return Math.max(lh,rh) + 1;
    }

    // O(n^2)
    static boolean isTreeBalanced(Node root) {
      if (root == null) return true;
      int lh = heightOfTree(root.left);
      int rh = heightOfTree(root.right);
      return Math.abs(lh - rh) <= 1
              && isTreeBalanced(root.left)
              && isTreeBalanced(root.right);
  }

    static int heightOfTree(Node root) {
        if (root == null) return 0;
        else return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }
}
