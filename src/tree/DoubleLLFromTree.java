package tree;

public class DoubleLLFromTree {
    public static void main(String[] args) {
        /*
                 10
              /     \
             20     30
            /
           40
          / \
         9   7
         */
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.left.left = new Node(9);
        root.left.left.right = new Node(7);

        Node ddList = doubleLinkedListOfTree(root);
        traverseDDList(ddList);
    }

    static Node prev;
    static Node doubleLinkedListOfTree(Node root) {
        if (root == null) return null;
        Node head = doubleLinkedListOfTree(root.left);
        if (prev == null) head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        doubleLinkedListOfTree(root.right);
        return head;
    }

    static void traverseDDList(Node head) {
        if (head == null) return;
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }
}
