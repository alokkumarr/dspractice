package linklist.gfg;

public class InsertCircularNode {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20);
        node.next.next = new Node(30);
        node.next.next.next = node;

        //PrintCircularList.printCList(node);
        Node head = insertAtStartEfficient(node, 45);
        PrintCircularList.printCList(head);
        Node head1 = inserAtEnd(node, 45);
        //PrintCircularList.printCList(head1);

    }


    private static Node insertAtStartEfficient(Node head, int data) {
        Node tmp = new Node(data);

        if(head == null) {
            tmp.next = tmp;
            return tmp;
        }

        tmp.next = head.next;
        head.next = tmp;

        // swap the data 1 and 2nd
        int x = head.data;
        head.data = head.next.data;
        head.next.data = x;

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
