package leetcode;

import java.util.PriorityQueue;

public class MergeKthSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int si, int ei) {
        if (si > ei) return null;
        if (si == ei) return lists[si];
        // this function will be called recursive till it reached to one
        // then merge both lists
        int mid = (si + ei) / 2;
        ListNode l1 = mergeKLists(lists, 0, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, ei);
        return merge(l1, l2);
    }

    static public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }   else  {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // if any one of is null
        tail.next = l1 == null ? l2 : l1;

        return dummy.next;
    }


    // O(KNlogN) best solution
    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> {
           return a.val - b.val;
        });

        // add first element of list
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }

        // create dummy node
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!pq.isEmpty()) {
            ListNode temp = pq.remove();

            tail.next = temp;
            tail = tail.next;
            temp = temp.next;

            // add new node to queue
            if (temp != null) pq.add(temp);
        }
        return dummy.next;
    }
}
