package linklist;

public class DeleteNode {
    public static void main(String[] args) {
        // 10 => 20 => 30 => 40
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        Node newLL =deleteAtFirst(head);
        printLL(newLL);

        System.out.println();
        newLL =deleteAtLast(head);
        printLL(newLL);

    }

    private static Node deleteAtFirst(Node head) {
        if (head == null) return null;
        return head.next;
    }

    // 10 => 20 => 30 => 40 => 50 =>
    private static Node deleteAtLast(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    // 10 => 20 => 30 => 40 => 50 =>
    private static Node deleteAtKthPosition(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
        return head;
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
