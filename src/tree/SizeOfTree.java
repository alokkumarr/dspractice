package tree;

public class SizeOfTree {

    public static void main(String[] args) {
        /**
         *        10
         *     /     \
         *    20     30
         *   /  \    / \
         *  40   50 60  70
         */
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        System.out.println("Size of tree : " + sizeOfTree(root));
    }

    static int sizeOfTree(Node root) {
        if(root == null) return  0;
        return 1 + sizeOfTree(root.left) + sizeOfTree(root.right);
    }
}
