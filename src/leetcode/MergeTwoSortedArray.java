package leetcode;

public class MergeTwoSortedArray {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null)
            return list1 == null ? list2 : list1;

        // create a dummy node
        ListNode dummy = new ListNode();
        // Initialize with dummy
        ListNode cur = dummy;
        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        // if anyone of is ends
        dummy.next = (list1 == null ? list2 : list1);
        return dummy.next;
    }
}
