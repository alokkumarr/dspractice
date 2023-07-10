package linklist.gfg;

public class SortedListInsertData {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20);
        node.next.next = new Node(30);
        System.out.println("-----------------");
        Node newNode1 = insert(node, 50);
        PrintList.printList(newNode1);
    }

    private static Node insert(Node head, int data) {
        Node tmp = new Node(data);
        if (head == null)
            return tmp;

        if (data < head.data) {
            tmp.next = head;
            return tmp;
        }

        Node curr = head;
        while (curr.next != null && curr.next.data < data) {
            curr = curr.next;
        }
        tmp.next = curr.next;
        curr.next = tmp;

        return head;
    }

}
