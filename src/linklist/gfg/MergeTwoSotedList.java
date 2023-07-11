package linklist.gfg;

public class MergeTwoSotedList {

    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20);
        node.next.next = new Node(30);
        node.next.next.next = new Node(36);
        node.next.next.next.next = new Node(40);
        node.next.next.next.next.next = new Node(50);

        PrintList.printList(node);
        System.out.println();

        Node node1 = new Node(10);
        node1.next = new Node(25);
        node1.next.next = new Node(32);
        node1.next.next.next = new Node(34);
        node1.next.next.next.next = new Node(35);
        node1.next.next.next.next.next = new Node(50);
        PrintList.printList(node1);
        System.out.println();
        node = solution(node, node1);
        PrintList.printList(node);
    }


    private static Node solution(Node head1, Node head2) {
        if (head1 == null)
            return head2;

        if (head2 == null)
            return head1;

        Node head = null, tail = null;

        if (head1.data > head2.data) {
            head = head2;
            tail = head2;
            head2 = head2.next;
        } else {
            head = head1;
            tail = head1;
            head1 = head1.next;
        }

        while (head1 != null && head2.next != null) {
            if (head1.data < head2.data) {
                tail.next = head1;
                tail = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }

        if (head1 == null)
            tail.next = head2;
        else
            tail.next = head1;

        return head;
    }

}
