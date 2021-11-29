package linklist;

public class RemoveDuplicate {
    public static void main(String[] args) {
        // 10 => 20 => 30 => 40
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(20);
        head.next.next.next = new Node(40);
        printNodeRec(head);
        System.out.println();
        Node list = removeDuplicates(head);
        printNodeRec(list);
    }

    private static Node removeDuplicates(Node head) {
        if (head == null || head.next == null) return head;
        Node curr = head;
        while (curr.next != null) {
            if (curr.data == curr.next.data){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }


    private static void printNodeRec(Node head) {
        if (head == null) return;
        System.out.print(head.data + " -> ");
        printNodeRec(head.next);
    }
}
