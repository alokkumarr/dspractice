package binarysearchtree.gfg;

public class FindKthSmallestElement {

    public static void main(String[] args) {

        /*
          Find kth smallest element
                 50
               /    \
             20      100
            /  \     /  \
           10  40  70    120
                  / \
                60  80

                k = 3
                O/P - 40
                k =2
                O/P = 20
         */
        Node root = null;
        int keys[] = { 20, 8, 22, 4, 12, 10, 14 };

        for (int x : keys)
            root = insert(root, x);

        int k = 3;
        Node res = kthSmallest(root, k);
        System.out.println(res.data);

    }

    public static Node kthSmallest(Node root, int k) {
        if (root == null)
            return null;

        int count = root.lCount + 1;
        if (count == k)
            return root;

        if (count > k)
            return kthSmallest(root.left, k);

        return kthSmallest(root.right, k - count);
    }

    public static Node insert(Node root, int x)  {
        if (root == null)
            return new Node(x);

        if (x < root.data) {
            root.left = insert(root.left, x);
            root.lCount++;
        }

        else if (x > root.data)
            root.right = insert(root.right, x);
        return root;
    }


    static int count = 0;
    private static void findKthSmallestNaive(Node root, int k) {
        if (root != null) {
            findKthSmallestNaive(root.left, k);
            count++;
            if (count == k) {
                System.out.println(root.data);
                return;
            }
            findKthSmallestNaive(root.right,k);
        }
    }

}

class Node {
    int data;
    Node left;
    Node right;
    int lCount;
    Node(int data) {
        this.data = data;
    }
}
