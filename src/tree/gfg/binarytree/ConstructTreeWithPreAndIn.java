package tree.gfg.binarytree;

import tree.gfg.Node;

public class ConstructTreeWithPreAndIn {
    // consider there will be no duplicate in pre and in order array

    public static void main(String[] args) {
        int[] pre = {10,20,30,40,50};
        int[] in = {20,10,40,30,50};

        Node root = constructTree(pre, in, 0, in.length -1);
        TreeTraversal.inOrderTraversal(root);
    }

    static int preIndex = 0;
    private static Node constructTree(int[] pre, int[] in, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;

        Node root = new Node(in[preIndex++]);

        int inIndex = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.key) {
                inIndex = i;
            }
        }

        root.left = constructTree(pre, in, inStart, inIndex-1);
        root.right = constructTree(pre, in, inIndex+1, inEnd);


        return root;

    }
}
