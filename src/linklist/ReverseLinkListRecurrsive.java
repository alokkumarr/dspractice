package linklist;

public class ReverseLinkListRecurrsive {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = new Node(40);

        traverse(head);
        Node newList = reverseLinkList(head,null);
        System.out.println();
        traverse(newList);
    }

    private static Node reverseLinkList(Node curr, Node prev) {
        if (curr == null) return prev;
        Node next = curr.next;
        curr.next = prev;
        return reverseLinkList(next, curr);

    }
    private static Node reverseLinkList(Node head) {
        if (head == null || head.next == null)
            return head;

        Node restHead = reverseLinkList(head.next);
        Node newTail = head.next;
        newTail.next=head;
        head.next=null;

        return restHead;
    }


    static void traverse(Node head) {
        if (head == null) return;
        System.out.print(head.data + " -> ");
        traverse(head.next);
    }
}
