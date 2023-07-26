package binarysearchtree;

public class DeleteNodeInBST {

    public static void main(String[] args) {
        /*
          A tree is balanced when its left or right tree diff is 0 or 1.
                 15
               /    \
             5       20
            /       /  \
           3      18    80
                 /
                16
         */
        Node root = new Node(15);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.right.left = new Node(18);
        root.right.right = new Node(80);
        root.right.left.left = new Node(16);

    }

    static Node deleteNode(Node root, int k) {
        if (root == null) return null;
        if (root.data > k) root.left = deleteNode(root.left, k);
        else if (root.data < k) root.right = deleteNode(root.right, k);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                Node suu = getSuccessor(root);
                root.data = suu.data;
                root.right = deleteNode(root.right, k);
            }
        }
        return root;
    }

    static Node getSuccessor(Node root) {
        Node curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
}
