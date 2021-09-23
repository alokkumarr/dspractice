package linklist;

public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    int carry = 0;
    while (l1 != null || l2 != null) {

      // check if value is null then value is 0
      int l1Val = l1 != null ? l1.val : 0;
      int l2Val = l2 != null ? l2.val : 0;

      // add the sum
      int curSum = l1Val + l2Val + carry;
      carry = curSum / 10;
      int lastDigit = curSum % 10;

      // create an add new node
      curr.next = new ListNode(lastDigit);
      curr = curr.next;

      if(l1 != null) l1 =  l1.next;
      if(l2 != null) l2 = l2.next;
    }

    if (carry > 0) {
      curr.next = new ListNode(carry);
    }
     return dummy.next;
  }
}

