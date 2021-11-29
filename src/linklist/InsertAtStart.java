package linklist;

public class InsertAtStart {
    public static void main(String[] args) {
        // 10 => 20 => 30 => 40
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        Node newList = insertAtStart(head, 80);
        printLL(newList);
    }

    private static void printLL(Node head) {
        if (head == null) return;
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " => ");
            cur = cur.next;
        }
    }

    private static Node insertAtStart(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) return temp;
        temp.next = head;
        return temp;
    }
}
