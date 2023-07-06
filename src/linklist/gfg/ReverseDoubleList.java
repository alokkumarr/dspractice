package linklist.gfg;

public class ReverseDoubleList {

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
        DNode resHead = reverseSimple(head);
        System.out.println("-----------");
        PrintDoubleList.printDoubleList(resHead);
    }


    private static DNode reverseSimple(DNode head) {
        if (head == null || head.next == null)
            return head;

        DNode pt1 = head;
        DNode pt2 = pt1.next;

        pt1.next = null;
        pt1.prev = pt2;

        while (pt2 != null) {
            pt2.prev = pt2.next;
            pt2.next = pt1;
            pt1 = pt2;
            pt2 = pt2.prev;
        }
        return pt1;
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
