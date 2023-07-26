package binarysearchtree;

public class InsertBinarySearchTree {
    public static void main(String[] args) {
        /*
          A tree is balanced when its left or right tree height diff is 0 or 1.
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

        /*
          New BST
                 15
               /    \
             5       20
            /       /  \
           3      18    80
                 /     /
                16    30
         */
        traverse(insertRec(root, 30));
        System.out.println();
        traverse(insert(root, 30));
    }

    static void traverse(Node root) {
        if (root == null) return;
        traverse(root.left);
        System.out.print(root.data + "->");
        traverse(root.right);
    }

    static Node insert(Node root, int k) {
        // create a temp root
        Node tmp = new Node(k);

        if (root == null) {
            return tmp;
        }

        Node cur = root;

        Node parent = null;
        while (cur != null) {
            parent = cur;
            if (cur.data > k) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        } // end of wile loop, found the position where element to be inserted

        if (parent.data > k) {
            parent.left = tmp;
        } else {
            parent.right = tmp;
        }
        return root;
    }

    static Node insertRec(Node root, int k) {
        Node tmp = new Node(k);
        if (root == null) {
            return tmp;
        } else if (root.data > k) {
            root.left =  insertRec(root.left, k);
        } else if(root.data < k){
            root.right =  insertRec(root.right, k);
        }
        return root;
    }
}
