package linklist.gfg;

public class PrintCircularList {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20);
        node.next.next = new Node(30);
        node.next.next.next = node;

        printCList(node);
    }

    public static void printCList(Node head) {

        if (head == null) return;

        Node p = head;
        do {
            System.out.print(p.data + " ");
            p = p.next;
        } while (p != head);

    }
}
