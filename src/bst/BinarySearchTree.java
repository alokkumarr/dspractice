package bst;

public class BinarySearchTree {
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

        int k = 18;
        boolean haveElement = searchNaive(root, k);
        System.out.println(haveElement);
    }

    // O(h)
    private static boolean searchNaiveRec(Node root, int k) {
        if (root == null) return false;
        else if (root.data == k) {
            return true;
        } else if (root.data < k) {
            return searchNaiveRec(root.right, k);
        } else  {
            return searchNaiveRec(root.left,k);
        }
    }

    // O(h)
    private static boolean searchNaive(Node root, int k) {
        if (root == null) return false;
        while (root != null) {
            if (root.data == k) {
                return true;
            } else if (root.data > k) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return false;
    }
}
