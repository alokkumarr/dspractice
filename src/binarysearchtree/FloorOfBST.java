package binarysearchtree;

public class FloorOfBST {

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

        int key  = 21;
        Node floorNode = findFloorBST(root, key);
        System.out.println(floorNode.data);
    }

    /**
     * floor of an element nearest close element
     * in above case floor of 17 is 16.
     *
     */
    static Node findFloorBST(Node root, int key) {
        if (root == null) return null;
        Node res = null;

        while (root != null) {
            if (root.data == key){
                return root;
            } else if (root.data > key) {
                root = root.left;
            } else {
                res = root;
                root = root.right;
            }
        }
        return res;
    }
}
