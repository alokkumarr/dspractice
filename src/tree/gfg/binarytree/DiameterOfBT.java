package tree.gfg.binarytree;

import tree.gfg.Node;

public class DiameterOfBT {
    public static void main(String[] args) {
        /*
         *      10
         *     /  \
         *    20   70
         *   /  \
         *  40   90
         *      /
         *     21
         *      \
         *       87
         *  O/P - > 10 20 40 21
         */
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(70);
        root.left.left = new Node(40);
        root.left.right = new Node(90);
        root.left.right.left = new Node(21);
        root.left.right.left.right = new Node(87);

        int res = diameter(root);
        System.out.println("Height : " + res + " & Diameter : " + diameter);
    }


    /* Start Solution - O(n) - Time and Space */
    static int diameter = 0;
    private static int diameter(Node root) {
        if (root == null)
            return 0;
        else {
            int lh = diameter(root.left);
            int rh = diameter(root.right);
            diameter = Math.max(diameter, 1+ lh + rh);
            return 1 + Math.max(lh, rh);
        }
    }
    /* End Solution */
}
