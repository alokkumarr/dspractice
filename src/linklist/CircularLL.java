package linklist;

public class CircularLL {
    public static void main(String[] args) {
        CCNode head = new CCNode(10);
        CCNode tmp1 = new CCNode(20);
        CCNode tmp2 = new CCNode(30);
        CCNode tmp3 = new CCNode(40);

        head.next = tmp1;
        tmp1.next = tmp2;
        tmp2.next = tmp3;
        tmp3.next = head;

        traverseCLL(head);

        System.out.print("\n-------------------------\n");
        int data = 5;
        CCNode list = insertAtStartBest(head, data);
        traverseCLL(list);

        System.out.print("\n-------------------------\n");
        data = 50;
        list = insertAtStartLast(head, data);
        traverseCLL(list);
        System.out.print("\n-------------------------\n");

        list = deleteAtStartBest(list);
        traverseCLL(list);
        System.out.print("\n-------------------------\n");
    }

    //O(1)
    static CCNode deleteAtStartBest(CCNode head) {
        if (head == null || head.next == head) {
            return null;
        }
        head.data = head.next.data;
        head.next = head.next.next;
        return head;
    }

    // O(n)
    private static CCNode deleteAtStart(CCNode head) {
        if (head == null || head.next == head) {
            return null;
        }

        CCNode cur = head;
        while (cur.next != head) {
            cur = cur.next;
        }
        cur.next = head.next;
        return cur.next;
    }

    // O(1) - first insert the tmp data next to head
    // then swap the data and change the head to head next
    private static CCNode insertAtStartLast(CCNode head, int data) {
        CCNode tmp = new CCNode(data);
        if (head == null) {
            tmp.next = tmp;
            return tmp;
        }
        tmp.next = head.next;
        head.next = tmp;

        int tmpData = head.data;
        head.data = tmp.data;
        tmp.data=tmpData;
        return head.next;
    }

    // O(n) time
    private static CCNode insertAtLast(CCNode head, int data) {
        CCNode tmp = new CCNode(data);
        if (head == null) {
            tmp.next = tmp;
            return tmp;
        }
        CCNode cur = head;
        while (cur.next != head) {
            cur = cur.next;
        }
        cur.next = tmp;
        tmp.next = head;
        return head;
    }


    // O(1) - first insert the tmp data next to head
    // then swap the data
    private static CCNode insertAtStartBest(CCNode head, int data) {
        CCNode tmp = new CCNode(data);
        if (head == null) {
            tmp.next = tmp;
            return tmp;
        }
        tmp.next = head.next;
        head.next = tmp;

        int tmpData = head.data;
        head.data = tmp.data;
        tmp.data=tmpData;
        return head;
    }

    // O(n) time
    private static CCNode insertAtStartNaive(CCNode head, int data) {
        CCNode tmp = new CCNode(data);
        if (head == null) {
            tmp.next = tmp;
            return tmp;
        }
        CCNode cur = head;
        while (cur.next != head) {
            cur = cur.next;
        }
        cur.next = tmp;
        tmp.next = head;
        return tmp;
    }

    static void traverseCLL(CCNode head) {
        if (head == null) return;
        System.out.print(head.data + "->");
        CCNode cur = head;
        for (CCNode ptr = cur.next; ptr != head; ptr = ptr.next){
            System.out.print(ptr.data + "->");
        }
    }
}

class CCNode {
    CCNode next;
    int data;

    CCNode(int data){
        this.data = data;
        next = null;
    }
}
