package linklist.gfg;

public class FindMiddleElement {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20);
        node.next.next = new Node(30);
        node.next.next.next = new Node(35);
        node.next.next.next.next = new Node(40);
        node.next.next.next.next.next = new Node(50);

        PrintList.printList(node);
        int res = findMidleElement(node);
        System.out.println(res);
    }

    private static int findMidleElement(Node head) {
        if (head == null)
            return -1;

        Node slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println();
        return slow.data;
    }
}
