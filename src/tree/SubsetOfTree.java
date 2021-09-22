package tree;

public class SubsetOfTree {
    /*
    Tree 1
              26
            /   \
          10     3
        /    \     \
      4       6      3
       \
        30

        Tree 2
          10
        /    \
      4       6
       \
        30
     */
    public static void main(String[] args) {
        Node roo1 = new Node(26);
        roo1.left = new Node(10);
        roo1.right = new Node(3);
        roo1.right.right = new Node(3);
        roo1.left.left = new Node(4);
        roo1.left.right = new Node(6);
        roo1.left.left.right = new Node(30);

        Node roo2 = new Node(10);
        roo2.left = new Node(4);
        roo2.right = new Node(6);
        roo2.left.right = new Node(30);

        System.out.println("isSubsetOfTree : " + isSubsetOfTree(roo1, roo2));
    }

     static boolean isSubsetOfTree(Node T, Node S) {
         if (S == null) return true;
         if (T == null) return false;

        if (isIdenticalTree(T, S)) return true;

        return isSubsetOfTree(T.left, S) || isIdenticalTree(T.right, S);
    }


    static boolean isIdenticalTree(Node root1, Node root2) {
        // base case if both are null same time
        if (root1 == null && root2 == null) return true;
        // if any of the null
        if (root1 == null || root2 == null) return false;

        return root1.data == (root2.data)
                && isSubsetOfTree(root1.left, root2.left)
                && isIdenticalTree(root1.right, root2.right);
    }
}
