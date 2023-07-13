package linklist.gfg;

public class NthNodeFromEnd {

    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20);
        node.next.next = new Node(30);
        node.next.next.next = new Node(35);
        node.next.next.next.next = new Node(40);
        node.next.next.next.next.next = new Node(45);

        //printList(node);
        printNthFromLastNode(node, 3);
        System.out.println();
    }

    private static void printNthFromLastNode(Node head, int n) {
        if (head == null) return;

        Node first = head;
        for (int i =0; i<n; i++) {
            if (first == null) return;
            first = first.next;
        }

        Node sec = head;
        while (first != null) {
            first = first.next;
            sec = sec.next;
        }

        System.out.println(sec.data);
    }

}
