package tree;

public class HeightOfTree {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.right.right = new Node(50);

        int height = heightOfTree(root.right.right );
        System.out.println("Height of tree : " + height);
    }
    static int heightOfTree(Node root) {
        if (root == null) return 0;
        else return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }
    // Complexity - O(h)
}
