package linklist.gfg;

public class DeleteCircularNode {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20);
        node.next.next = new Node(30);
        node.next.next.next = node;
        PrintCircularList.printCList(node);

        Node head1 = null;//deletetAtStartEfficient(node);
        PrintCircularList.printCList(head1);
        head1 = deleteAtKthPosition(node, 2);
        PrintCircularList.printCList(head1);
    }

    private static Node deleteAtKthPosition(Node head, int pos) {
        if (head == null) return null;
        if (pos == 1)
            return deleteAtStart(head);

        int i = 0;
        Node curr = head;
        while (i < pos-2) {
            curr = curr.next;
            i++;
        }

        curr.next = curr.next.next;
        System.out.println();
        return head;
    }

    private static Node deleteAtStart(Node head) {
        if (head == null) return null;
        if (head.next == head) return null;

        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }

        curr.next = head.next;
        System.out.println();
        return head.next;
    }


    private static Node deletetAtStartEfficient(Node head) {
        if(head == null || head.next == null) return null;

        // swap the data 1 and 2nd
        head.data = head.next.data;
        head.next = head.next.next;

        System.out.println();
        return head;
    }

    private static Node insertAtstart(Node head, int data) {
        Node tmp = new Node(data);

        if(head == null) {
            tmp.next = tmp;
            return tmp;
        }

        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }

        curr.next = tmp;
        tmp.next = head;
        System.out.println();
        return tmp;
    }

    private static Node inserAtEnd(Node head, int data) {
        Node tmp = new Node(data);

        if(head == null) {
            tmp.next = tmp;
            return tmp;
        }

        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }

        curr.next = tmp;
        tmp.next = head;
        System.out.println();
        return head;
    }
}
