package linklist;

public class ReverseDoublyLinkList {

    public static void main(String[] args) {
        DoubleNode head = new DoubleNode(10);
        DoubleNode tmp1 = new DoubleNode(20);
        DoubleNode tmp2 = new DoubleNode(30);
        DoubleNode tmp3 = new DoubleNode(40);

        head.next = tmp1;
        tmp1.prev = head;

        tmp1.next = tmp2;
        tmp2.prev = tmp1;

        tmp2.next = tmp3;
        tmp3.prev = tmp2;

        printDLL(head);
        System.out.println();

        DoubleNode newNode = reverseDoubleLinkList(head);
        printDLL(newNode);
        System.out.println();
    }

    static void printDLL(DoubleNode head) {
        if (head == null) return;
        DoubleNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
    }

    static DoubleNode reverseDoubleLinkList(DoubleNode head) {
        if (head == null || head.next == null) return head;
        DoubleNode prev = null, curr = head;
        while (curr != null) {
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;
            curr = curr.prev;
        }
        return prev.prev;
    }
}
