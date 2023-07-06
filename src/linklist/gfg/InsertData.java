package linklist.gfg;

public class InsertData {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20);
        node.next.next = new Node(30);
        Node newNode = insertAtStart(node, 40);
        PrintList.printList(newNode);
        System.out.println();
        System.out.println("-----------------");
        Node newNode1 = insertAtLast(node, 40);
        PrintList.printList(newNode1);
    }

    private static Node insertAtStart(Node head, int data) {
        Node tmp = new Node(data);
        if (head == null)
            return tmp;

        tmp.next = head;
        return tmp;
    }


    private static Node insertAtLast(Node head, int data) {
        Node tmp = new Node(data);
        if (head == null)
            return tmp;

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = tmp;
        return head;
    }

}
