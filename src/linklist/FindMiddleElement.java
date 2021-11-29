package linklist;

public class FindMiddleElement {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(25);
        Node temp3 = new Node(30);
        Node temp4 = new Node(40);
        Node temp5 = new Node(50);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = new Node(50);

        traverse(head);
        System.out.println();
        System.out.println("------------------------");

        int mid = findMiddleElement(head);
        System.out.println("Middle Element : " + mid);
    }

    private static int findMiddleElement(Node head) {
        if (head == null) return -1;
        if (head.next == null) return head.data;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    static void traverse(Node head) {
        if (head == null) return;
        if (head.next == null) System.out.print(head.data + "->");

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
    }
}
