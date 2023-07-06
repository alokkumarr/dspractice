package linklist.gfg;

public class InsertDoubleList {
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
        DNode node = insertAtEnd(head,55);
        System.out.println("-----------");
        PrintDoubleList.printDoubleList(node);
    }

    private static DNode insertAtStart(DNode head, int data) {
        DNode tmp = new DNode(data);
        if (head == null)
            return tmp;

        head.prev = tmp;
        tmp.next = head;
        return tmp;
    }

    private static DNode insertAtEnd(DNode head, int data) {
        DNode tmp = new DNode(data);
        if (head == null)
            return tmp;

        DNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        tmp.prev = curr;
        curr.next = tmp;

        return head;
    }
}
