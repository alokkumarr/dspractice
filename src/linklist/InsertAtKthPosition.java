package linklist;

public class InsertAtKthPosition {
    public static void main(String[] args) {
        // 10 => 20 => 30 => 40
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        Node newList = insertAtPosition(head, 80,5);
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

    // 10 => 20 => 30 => 40
    private static Node insertAtPosition(Node head, int data, int pos) {
        Node temp = new Node(data);
        if (head == null) return temp;
        if (pos == 1) {
            temp.next = head;
            return temp;
        }

        int count = 1;
        Node curr = head;
        while (curr.next != null && count < pos-1) {
            curr = curr.next;
            count++;
        }
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }
}
