package linklist;

public class InsertDataInSortedLL {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = new Node(40);

        traverse(head);
        System.out.println("\n-------------------\n");
        int data = 25;
        head = insertData(head, data);
        traverse(head);
    }

    private static Node insertData(Node head, int data) {
        Node tmp = new Node(data);
        if (head == null) return null;
        if (head.next == null) {
            if (head.data > data) {
                head.next = tmp;
            }else {
                tmp.next = head;
                return tmp;
            }
        }

        return head;
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
