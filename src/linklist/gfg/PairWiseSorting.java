package linklist.gfg;

public class PairWiseSorting {

    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20);
        node.next.next = new Node(30);
        node.next.next.next = new Node(35);
        node.next.next.next.next = new Node(40);
        //node.next.next.next.next.next = new Node(50);

        PrintList.printList(node);
        System.out.println();
        node = solution1(node);
        PrintList.printList(node);
    }


    private static Node solution1(Node head) {
        if (head == null || head.next == null)
            return head;

        // first handle first 2 nodes
        Node curr = head.next.next;
        Node prev = head;
        head = head.next;
        head.next = prev;

        // handle 3rd node onwards
        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            prev = curr;
            Node next = curr.next.next;
            curr.next.next = curr;
            curr = next;
        }
        prev.next = curr;
        return head;
    }


    /**
     *this solution will work only when we have only one data.
     * if node is having object this solution is not correct
     */
    private static Node solution(Node head) {
        if (head == null || head.next == null)
            return head;
        Node curr = head;
        while (curr != null && curr.next != null) {
            int temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = temp;
            curr = curr.next.next;
        }
        return head;
    }

}
