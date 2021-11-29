package linklist;

import java.util.HashSet;
import java.util.Set;

public class DetectLoopInLL {
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

        boolean isLoop =detectLoop(head);
        System.out.println();
        System.out.println("Loop detected : " + isLoop);

    }

    // use of hash table
    // O(n) - time and space complexity
    private static boolean detectLoop(Node head) {
        Set<Node> hashSet = new HashSet<Node>();
        Node cur = head;
        while (cur != null) {
            if (hashSet.contains(cur)) {
                return true;
            } else {
                hashSet.add(cur);
            }
            cur = cur.next;
        }
        return false;
    }


    // use of extra space and did not traverse the link list
    // In this approach we are destructuring the link list
    private static boolean detectLoopByTempSpace(Node head) {
        Node tmp = new Node(0);
        Node cur = head;
        while (cur != null) {
            if (cur.next == null) return false;
            if (cur.next == tmp) {
                return true;
            }
            Node currNext = cur.next;
            cur.next = tmp;
            cur = currNext;
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
