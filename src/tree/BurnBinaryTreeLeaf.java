package tree;

public class BurnBinaryTreeLeaf {
    public static void main(String[] args) {
        /**
         *            10
         *           /
         *          20
         *         /  \
         *       30    5
         *      /  \
         *     40  50
         *    /
         *   60
         *  /
         * 70
         */
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.right = new Node(5);
        root.left.left = new Node(30);
        root.left.left.left = new Node(40);
        root.left.left.right = new Node(50);
        root.left.left.left.left = new Node(60);
        root.left.left.left.left.left = new Node(70);
    }
}
