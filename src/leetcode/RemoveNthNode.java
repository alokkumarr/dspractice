package leetcode;

public class RemoveNthNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode temp1 = new ListNode(20);
        ListNode temp2 = new ListNode(25);
        ListNode temp3 = new ListNode(30);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = new ListNode(40);

        traverse(head);

        ListNode node = removeNthFromEnd(head, 2);
        traverse(node);

    }

    static public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        if (head == null) return null;

        // start fast node at n th
        for (int i = 0; i < n; i++) {
            fast = head.next;
        }

        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    static void traverse(ListNode head) {
        if (head == null) return;
        System.out.print(head.val + " -> ");
        traverse(head.next);
    }
}
 class ListNode {
 int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
