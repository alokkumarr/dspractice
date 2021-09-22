package tree;

public class DiameterOfTree {

    public static void main(String[] args) {
        /**
         *        10
         *     /     \
         *    20     30
         *   /  \    / \
         *  40   50 60  70
         *
         *  Output -> 10 20 30 40 50 60 70
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int dia = diameterOfTree(root);
        System.out.println(dia);
    }

    static int res = 0;
    private static int diameterOfTree(Node root) {
        if (root == null) return 0;
        height(root);
        return res;
    }

    static int height(Node root){
        if (root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        res = Math.max(res, 1 + lh + rh);

        return 1 + Math.max(lh, rh);
    }
}
