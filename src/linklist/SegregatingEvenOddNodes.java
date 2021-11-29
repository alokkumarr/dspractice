package linklist;

public class SegregatingEvenOddNodes {
    public static void main(String[] args) {
        // 10 => 20 => 30 => 40
        Node head = new Node(10);
        head.next = new Node(21);
        head.next.next = new Node(30);
        head.next.next.next = new Node(41);
        head.next.next.next.next = new Node(50);
        printLL(head);
        System.out.println();

        Node newLL = segregateLL(head);
        printLL(newLL);
    }

    private static Node segregateLL(Node head) {
        Node os = null, oe = null, es = null, ee = null;
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.data % 2 == 0) {
                if (es == null) {
                    es = cur;
                    ee = es;
                } else {
                    ee.next = cur;
                    ee = ee.next;
                }
            } else {
                if (os == null) {
                    os = cur;
                    oe = os;
                } else {
                    oe.next = cur;
                    oe = oe.next;
                }
            }
        }

        // after loop ends
        if (es == null || os == null) {
            return head;
        }

        //System.out.println();
        //printLL(es);
        //printLL(os);

        ee.next = os;
        oe.next = null;
        return es;
    }

    private static void printLL(Node head) {
        if (head == null) return;
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " => ");
            cur = cur.next;
        }
    }
}
