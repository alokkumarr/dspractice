package tree.gfg.binarytree;

import tree.gfg.Node;

public class CountNodeInCompleteBT {
    public static void main(String[] args) {
        /*
         *        10
         *     /      \
         *    20      70
         *   /  \    /  \
         *  40   90 21   87
         *
         *  O/P - > 7
         */
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(70);

        root.left.left = new Node(40);
        root.left.right = new Node(90);

        root.right.left = new Node(21);
        root.right.right = new Node(87);

        int res = count(root);
        System.out.println("Total Node : " + res);
    }

    // O(log n  * log n )
    private static int count(Node root) {
        if (root == null) return 0;

        int lh = 0, rh = 0;
        Node curr = root;
        while(curr!=null){
            lh++;
            curr=curr.left;
        }
        curr=root;
        while(curr!=null){
            rh++;
            curr=curr.right;
        }


        if (lh == rh)
            return (int) Math.pow(2, lh) -1;
        else
            return 1 + count(root.left) + count(root.right);
    }
}
