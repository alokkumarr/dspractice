package leetcode;

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode l1 = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode l2 = reverse(slow);
        merge(l1, l2);
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l2 != null) {
            ListNode l1Next = l1.next;
            l1.next = l2;
            l1 =  l2;
            l2 = l1Next;
        }
    }


    private ListNode reverse(ListNode root) {
        ListNode prev = null;
        ListNode curr = root;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

}
