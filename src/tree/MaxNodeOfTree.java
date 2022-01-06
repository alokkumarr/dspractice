package tree;

public class MaxNodeOfTree {

    /**
     * maximum value of the node
     *        10
     *     /     \
     *    20     30
     *   /  \    / \
     *  40   50 60  70
     */
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(100);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        System.out.println("Max element of tree : " + maxOfTree(root));
    }

    static int maxOfTree(Node root) {
        if(root == null) return  Integer.MIN_VALUE;
        return Math.max(root.data,
                Math.max(maxOfTree(root.left), maxOfTree(root.right)));
    }
}
