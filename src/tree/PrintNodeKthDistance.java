package tree;

public class PrintNodeKthDistance {

    public void printKthDistance(Node root, int k) {
        if (root == null) return;
        if (k == 0) System.out.println(root.key + " ");
        else {
            printKthDistance(root.left, k - 1);
            printKthDistance(root.right, k - 1);
        }
    }

    // complexity - O(n)
    // aux space big o (h)
}
