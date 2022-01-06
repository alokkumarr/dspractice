package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKthSortedList {


    public static void main(String[] args) {

        // [[1,4,5],[1,3,4],[2,6]]
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] list = {node1, node2, node3};
        ListNode sorted = mergeKListsQueue(list);
        printList(sorted);
    }

    private static void printList(ListNode sorted) {
        if (sorted == null) return;
        while (sorted != null) {
            System.out.print(sorted.val + " ");
            sorted = sorted.next;
        }
    }


    // O(KNlogN) best solution
    public static ListNode mergeKListsQueue(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        // add first element of list
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }

        // [[1,4,5],[1,3,4],[2,6]]
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
}
