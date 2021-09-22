package tree;

import java.util.HashMap;
import java.util.Map;

public class BuildBinaryTreeWithInPreArray {

    public static void main(String[] args) {
        int[] pre = {10,20,30,40,50};
        int[] in =  {20,10,40,30,50};

        int inStartIndex = 0, inEndIndex = in.length-1;
        /*Node tree = buildBinaryTree(in, pre, inStartIndex, inEndIndex);

        // print pre order
        TreeTraversalRec.inorderTraversal(tree);
*/
        // build a map with inorder data[index] and index
        for (int i = 0; i<in.length; i++) {
            map.put(in[i],i);
        }
        System.out.println();
        System.out.println(map);

        Node node = buildBinaryTreeEfficient(in, pre, inStartIndex, inEndIndex);
        // print pre order
        TreeTraversalRec.inorderTraversal(node);

    }

    static int preIndex = 0;

    // O(n) time complexity
    static Map<Integer, Integer> map = new HashMap<>();
    static Node buildBinaryTreeEfficient(int[] in, int[] pre, int iS, int iE) {
        if (iS > iE) return null;

        Node root = new Node(pre[preIndex++]);
        if (iS == iE) return root;

        int inIndex = map.get(root.data);
        root.left = buildBinaryTree(in, pre, iS, inIndex-1);
        root.right = buildBinaryTree(in, pre, inIndex+1, iE);

        return root;
    }

    // O(n^2)
    static Node buildBinaryTree(int[] in, int[] pre, int iS, int iE) {
        if (iS > iE) return null;
        Node root = new Node(pre[preIndex++]);
        if (iS == iE) return root;
        int inIndex = 0;
        for (int i = iS; i <= iE; i++) {
            if (in[i] == root.data) {
                inIndex = i;
                break;
            }
        }
        root.left = buildBinaryTree(in, pre, iS, inIndex-1);
        root.right = buildBinaryTree(in, pre, inIndex+1, iE);
        return root;
    }
}
