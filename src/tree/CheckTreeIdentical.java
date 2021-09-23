package tree;

public class CheckTreeIdentical {
    public static void main(String[] args) {
          /*
    Tree 1
           10
        /    \
      4       6
       \
        30

        Tree 2
          10
        /    \
      4       6
       \
        30
     */
        Node roo1 = new Node(10);
        roo1.left = new Node(4);
        roo1.right = new Node(6);
        roo1.left.right = new Node(30);

        Node roo2 = new Node(10);
        roo2.left = new Node(4);
        roo2.right = new Node(6);
        roo2.left.right = new Node(30);

        System.out.println("Is tree are same :" + isIdenticalTree(roo1, roo2));
    }

    static boolean isIdenticalTree(Node root1, Node root2) {
        // base case if both are null same time
        if (root1 == null && root2 == null) return true;
        // if any of the null
        if (root1 == null || root2 == null) return false;

        return root1.data==root2.data
                && isIdenticalTree(root1.left, root2.left)
                && isIdenticalTree(root1.right, root2.right);
    }
}
