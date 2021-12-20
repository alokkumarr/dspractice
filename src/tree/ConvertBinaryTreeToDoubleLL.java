package tree;

public class ConvertBinaryTreeToDoubleLL {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.left.left = new Node(9);
        root.left.left.right = new Node(7);
        root.left.right = new Node(50);
        root.left.right.right = new Node(5);
        root.right.right = new Node(60);
        root.right.left = new Node(3);
        root.right.right.right = new Node(70);

        Node newNode = buildDLFromBinaryTree(root);

    }

    // traverse with inorder traversal
    // DFS - In-order, O(n) - time , O(h) - auxilary space
    static Node prev = null;
    static Node buildDLFromBinaryTree(Node root) {
        if (root == null) return root;
        Node head = buildDLFromBinaryTree(root.left);
        if (prev == null) head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        buildDLFromBinaryTree(root.right);
        return head;
    }
}
