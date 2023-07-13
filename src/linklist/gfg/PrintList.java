package linklist.gfg;

public class PrintList {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20);
        node.next.next = new Node(30);
        node.next.next.next = new Node(35);
        node.next.next.next.next = new Node(40);
        node.next.next.next.next.next = new Node(45);

        //printList(node);
        printListRecursion(node);
        System.out.println();
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void printListRecursion(Node head) {
        if (head == null)
            return;
        System.out.print(head.data + " ");
        printListRecursion(head.next);
    }
}
