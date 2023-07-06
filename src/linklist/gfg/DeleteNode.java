package linklist.gfg;

public class DeleteNode {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20);
        //node.next.next = new Node(30);
        Node newNode = deleteAtStart(node);
        PrintList.printList(newNode);
        System.out.println();
        System.out.println("-----------------");
        Node newNode1 = deleteAtLast(node);
        PrintList.printList(newNode1);
    }

    private static Node deleteAtLast(Node head) {
        if (head == null || head.next == null)
            return null;

        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    private static Node deleteAtStart(Node head) {
        if (head == null || head.next == null)
            return null;

        head = head.next;
        return head;
    }
}
