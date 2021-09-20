package tree;

public class MaxNodeOfTree {

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

        System.out.println("Max element of tree : " + maOfTree(root));
    }

    static int maOfTree(Node root) {
        if(root == null) return  Integer.MIN_VALUE;



        return Math.max(Integer.parseInt(root.data.toString()),
                Math.max(maOfTree(root.left), maOfTree(root.right)));
    }
}
