package linklist;

public class ReverseLinkList {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = new Node(40);

        traverse(head);
        Node newList = reverseLinkList(head);
        System.out.println();
        traverse(newList);
    }

    private static Node reverseLinkList(Node head) {
        if (head == null) return null;
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    static void traverse(Node head) {
        if (head == null) return;
        System.out.print(head.data + " -> ");
        traverse(head.next);

        /*Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }*/
    }
}
