package linklist;

public class DoubleLList {

    public static void main(String[] args) {
        DoubleNode head = new DoubleNode(10);
        DoubleNode tmp1 = new DoubleNode(20);
        DoubleNode tmp2 = new DoubleNode(30);
        DoubleNode tmp3 = new DoubleNode(40);

        head.next = tmp1;
        tmp1.prev = head;

        tmp1.next = tmp2;
        tmp2.prev = tmp1;

        tmp2.next = tmp3;
        tmp3.prev = tmp2;

        printDLL(head);
        System.out.println();

        DoubleNode newNode = insertAtStart(head, 20);
        printDLL(newNode);
        System.out.println();

        printDLL(insertAtEnd(newNode, 90));
        System.out.println();
    }

    static void printDLL(DoubleNode head) {
        if (head == null) return;
        DoubleNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
    }

    static DoubleNode deleteAtStart(DoubleNode head) {
        if (head == null || head.next == null) return null;
        head = head.next;
        head.prev = null;
        return head;
    }

    static DoubleNode deleteAtEnd(DoubleNode head) {
        if (head == null || head.next == null) return null;

        DoubleNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        // delete the last node
        cur.prev.next = null;
        return head;
    }

    static DoubleNode reverseDLL(DoubleNode head) {
        if (head == null || head.next == null)
            return head;
        DoubleNode cur = head, prv = null;
        while (cur != null){

        }

        return head;
    }

    static DoubleNode insertAtStart(DoubleNode head, int data){
        DoubleNode tmp = new DoubleNode(data);
        tmp.next = head;
        if (head != null)
            head.prev = tmp;

        return tmp;
    }

    static DoubleNode insertAtEnd(DoubleNode head, int data){
        DoubleNode tmp = new DoubleNode(data);
        if (head == null) {
            return tmp;
        }
        DoubleNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = tmp;
        tmp.prev = cur;

        return head;
    }
}

