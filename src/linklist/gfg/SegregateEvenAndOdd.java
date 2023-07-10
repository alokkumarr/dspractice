package linklist.gfg;

public class SegregateEvenAndOdd {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20);
        Node ptr = new Node(30);
        node.next.next = ptr;
        node.next.next.next = new Node(35);
        node.next.next.next.next = new Node(40);
        node.next.next.next.next.next = new Node(45);

        PrintList.printList(node);
        Node node1 = segregateEvenAndOdd(node);
        System.out.println();
        PrintList.printList(node1);
    }

    private static Node segregateEvenAndOdd(Node head) {
        Node es = null, ee = null, os = null, oe = null;
        Node curr = head;
        while ( curr != null) {

            int x = curr.data;
            if (x % 2 == 0){
                if (es == null) {
                    es  = ee = curr;
                } else {
                    ee.next = curr;
                    ee = ee.next;
                }
            } else {
                if (os == null) {
                    os = oe = curr;
                } else {
                    oe.next = curr;
                    oe = oe.next;
                }
            }
            curr = curr.next;
        }

        if (os == null || es == null)
            return head;

        // link even and odd list
        ee.next = os;
        oe.next = null;
        return es;
    }
}
