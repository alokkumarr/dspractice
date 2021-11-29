package linklist;

import java.util.HashSet;
import java.util.Set;

public class DetectAndRemoveLoopInLL {
    public static void main(String[] args) {
        // 10 => 20 => 30 => 40 => 50
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        Node temp = new Node(50);
        head.next.next.next.next = temp;

        // build a loop
        temp.next = head.next;
        //printLL(head);
        detectLoop(head);
        printLL(head);
    }

    // use of hash table
    // O(n) - time and space complexity
    private static void detectLoop(Node head) {
        Node slow = head, fast = head;
        // detect the loop by floyd algo
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow != fast) return;

        // remove the loop
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }

    private static void printLL(Node head) {
        if (head == null) return;
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " => ");
            cur = cur.next;
        }
    }
}
