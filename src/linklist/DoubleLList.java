package linklist;

public class DoubleLList {

    public static void main(String[] args) {
        DNode head = new DNode(10);
        DNode tmp1 = new DNode(20);
        DNode tmp2 = new DNode(30);
        DNode tmp3 = new DNode(40);

        head.next = tmp1;
        tmp1.prev = head;
        tmp1.next = tmp2;
        tmp2.prev = tmp1;
        tmp2.next = tmp3;
        tmp3.prev = tmp2;
    }

    static DNode deleteAtStart(DNode head) {
        if (head == null || head.next == null) return null;
        head = head.next;
        head.prev = null;
        return head;
    }

    static DNode deleteAtEnd(DNode head) {
        if (head == null || head.next == null) return null;

        DNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        // delete the last node
        cur.prev.next = null;
        return head;
    }

    static DNode reverseDLL(DNode head) {
        if (head == null || head.next == null)
            return head;
        DNode cur = head, prv = null;
        while (cur != null){

        }

        return head;
    }

    static DNode insertAtStart(DNode head, int data){
        DNode tmp = new DNode(data);
        tmp.next = head;
        if (head != null)
            head.prev = tmp;

        return tmp;
    }

    static DNode insertAtEnd(DNode head, int data){
        DNode tmp = new DNode(data);
        if (head == null) {
            return tmp;
        }
        DNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = tmp;
        tmp.prev = cur;

        return head;
    }
}

