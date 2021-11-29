package linklist;

import java.util.HashSet;
import java.util.Set;

public class DetectLoopByFloydCycle {
    public static void main(String[] args) {
        // 10 => 20 => 30 => 40 => 50
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        Node temp = new Node(50);
        head.next.next.next.next = temp;

        // build a loop
        //temp.next = head.next;
        //printLL(head);

        boolean isLoop =detectLoop(head);
        System.out.println();
        System.out.println("Loop detected : " + isLoop);

    }

    // in this will create two tracer
    // one is slow and second is second faster
    private static boolean detectLoop(Node head) {
        Node slow = head, fast = head;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
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
