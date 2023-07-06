package linklist.gfg;

public class PrintDoubleList {
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

        printDoubleList(head);
    }

    protected static void printDoubleList(DNode head) {
        if (head == null) return;

        DNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }


}
