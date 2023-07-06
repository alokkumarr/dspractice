package linklist.gfg;

public class PrintList {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20);
        node.next.next = new Node(30);
        //printList(node);
        printListRecursion(node);
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
