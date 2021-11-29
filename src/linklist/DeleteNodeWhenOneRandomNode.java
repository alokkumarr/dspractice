package linklist;

public class DeleteNodeWhenOneRandomNode {
    public static void main(String[] args) {
        // 10 => 20 => 30 => 40
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        printLL(head);
        System.out.println();
        Node newLL =deleteAtFirst(head);
        printLL(newLL);
    }

    private static Node deleteAtFirst(Node pointer) {
        pointer.data = pointer.next.data;
        pointer.next = pointer.next.next;
        return null;
    }

    private static void printLL(Node head) {
        if (head == null) return;
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " => ");
            cur = cur.next;
        }
    }


}
