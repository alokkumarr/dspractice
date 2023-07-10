package linklist.gfg;

public class DeleteNodeWithGivenPointer {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20);
        Node ptr = new Node(30);
        node.next.next = ptr;
        node.next.next.next = new Node(35);
        node.next.next.next.next = new Node(40);
        node.next.next.next.next.next = new Node(45);

        PrintList.printList(node);
        deleteNode(ptr);
        System.out.println();
        PrintList.printList(node);
    }

    private static void deleteNode(Node ptr) {
        ptr.data = ptr.next.data;
        ptr.next = ptr.next.next;
    }
}
