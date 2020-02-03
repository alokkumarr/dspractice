package tree;

public class TreeTraversal {

    public void inorderTraversal(Node root){
        if (root != null) {
            inorderTraversal(root.left);
            System.out.println(root.key + " ");
            inorderTraversal(root.right);
        }
    }

    public void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.println(root.key + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.key + " ");
        }
    }
}
