package tree;

public class CountNodeCompleteBT {

    public static void main(String[] args) {
        /**
         *        50
         *     /     \
         *    20     30
         *   /  \    / \
         *  10   10 20  10
         *
         *  Output -> 10 20 40
         */
        Node root = new Node(50);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(10);
        root.left.right = new Node(10);
        root.right.left = new Node(20);
        root.right.right = new Node(10);

        System.out.println(countAllNode(root));
    }

    static int countAllNodeBest(Node root) {
        int lh = 0, rh = 0;
        Node curr = root;
        while (curr != null) {
            lh++;
            curr = curr.left;
        }

        curr = root;
        while (curr != null) {
            rh++;
            curr = curr.right;
        }

        if (lh == rh)
            return (int) (Math.pow(2, lh) -1);

        return 1 + countAllNode(root.left) + countAllNode(root.right);
    }



    static int countAllNode(Node root) {
        if (root == null) return 0;
        return 1 +
                countAllNode(root.left) +
                countAllNode(root.right);
    }
}
