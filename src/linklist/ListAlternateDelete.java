package linklist;

public class ListAlternateDelete {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);

        printLL(root);
        System.out.println();
        alternateRemoval(root);
        printLL(root);
    }

    private static void alternateRemoval(Node head) {
        if (head == null)
            return;

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            /* Change next link of previous node */
            prev.next = curr.next;

            /* Free node */
            curr = null;

            /*Update prev and now */
            prev = prev.next;
            if (prev != null)
                curr = prev.next;
        }
    }


    private static void printLL(Node root) {
        while (root != null) {
            System.out.print(root.data + " ->");
            root = root.next;
        }
    }
}
