package linklist;

public class TraverseLinkList {
    public static void main(String[] args) {
        // 10 => 20 => 30 => 40
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        printNodeRec(head);
    }

    private static void printNode(Node head) {
        if (head == null) return;
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " => ");
            cur = cur.next;
        }
    }

    private static void printNodeRec(Node head) {
        if (head == null) return;
        System.out.print(head.data + " -> ");
        printNodeRec(head.next);
    }
}
