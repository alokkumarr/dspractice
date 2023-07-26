package binarysearchtree.gfg;

public class CheckForBST {
    /* Time complexity - O(n)
     *
     *                          30
     *                      /      \
     *                     20      60
     *                   /  \     /  \
     *                 10    25  50  70
     */
    public static void main(String[] args) {
        Node root = new Node(30);
        root.left = new Node(20);
        root.right = new Node(60);
        root.left.left = new Node(10);
        root.left.right = new Node(25);
        root.right.left = new Node(50);
        root.right.right = new Node(70);

        boolean flag = isBSTWithInOrderTraversal(root);
        System.out.println(flag);
    }


    // O(n) - 1st solution
    private static void haveBST(Node root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        boolean isBST = isBST(root, min, max);
        System.out.println(isBST);
    }

    private static boolean isBST(Node root, int min, int max) {
        if (root == null)
            return true;

        return root.data > min && root.data < max
                && isBST(root.left, min, root.data)
                && isBST(root.right, root.data, max);
    }


    // solution with inorder traversal
    // if this travesal sorted then the tree is BST

    static int prev = Integer.MIN_VALUE;
    private static boolean isBSTWithInOrderTraversal(Node root) {
        if(root == null) return true;

        if (!isBSTWithInOrderTraversal(root.left))
            return false;

        if (root.data <= prev)
            return false;
        prev = root.data;
        return isBSTWithInOrderTraversal(root.right);
    }


}
