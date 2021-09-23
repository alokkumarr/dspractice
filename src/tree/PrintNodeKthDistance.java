package tree;

public class PrintNodeKthDistance {


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
        root.right.right = new Node(50);

        printKthDistance(root, 1);
    }
    // complexity - O(n)
    // aux space big o (h)
    static void printKthDistance(Node root, int k) {
        if (root == null) return;
        if (k == 0) {
            System.out.print(root.data + " ");
        } else {
            printKthDistance(root.left, k - 1);
            printKthDistance(root.right, k - 1);
        }
    }
}
