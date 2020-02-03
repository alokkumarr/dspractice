package tree;

public class HeightOfTree {

    public int heightOfTree(Node root) {
        if (root == null) return 0;
        else return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }

    // Complexity - O(h)
}
