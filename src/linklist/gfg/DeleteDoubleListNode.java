package linklist.gfg;

public class DeleteDoubleListNode {

    public static void main(String[] args) {

        DNode head = new DNode(10);
        DNode tmp1 = new DNode(20);
        DNode tmp2 = new DNode(30);
        DNode tmp3 = new DNode(40);

        head.next = tmp1;
        tmp1.prev = head;

        tmp1.next = tmp2;
        tmp2.prev = tmp1;

        tmp2.next = tmp3;
        tmp3.prev = tmp2;

        PrintDoubleList.printDoubleList(head);
        DNode resHead = deleteLastDNode(head);
        System.out.println("-----------");
        PrintDoubleList.printDoubleList(resHead);
    }

    private static DNode deleteLastDNode(DNode head) {
        if (head == null || head.next == null)
            return null;

        DNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        // adjust last and second last pointer
        curr.prev.next = null;
        curr.prev = null;

        return head;
    }

    private static DNode deleteFirstDNode(DNode head) {
        if (head == null || head.next == null)
            return null;

        DNode curr = head;
        curr = curr.next;
        head.next = null;
        curr.prev = null;

        return curr;
    }

    private static DNode reverse(DNode head) {
        if (head == null || head.next == null)
            return head;

        // change the position of next and prev one by one
        DNode curr = head, prev = null;
        while (curr != null) {
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;

            curr = curr.prev;
        }

        return prev.prev;
    }
}
