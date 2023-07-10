package linklist.gfg;

import java.util.HashSet;
import java.util.Set;

public class DetectLoop {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20);
        node.next.next = new Node(30);
        node.next.next.next = new Node(35);
        node.next.next.next.next = new Node(40);
        node.next.next.next.next.next = new Node(45);
        node.next.next.next.next.next.next = node.next.next;

        //PrintList.printListRecursion(node);
        boolean haveLoop = detectLoopByFloyd(node);
        System.out.println(haveLoop);
        System.out.println(loopLength(node));
        detectLoopByFloydAndRemove(node);
        PrintList.printListRecursion(node);
    }

    private static int loopLength(Node head) {
        if (head == null || head.next == null) return -1;

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }


        int count = 0;
        while (fast != null) {
            fast = fast.next;
            count++;
            if (slow == fast) {
                return count;
            }
        }

        return count;
    }


    private static boolean detectLoopByFloyd(Node head) {
        if (head == null || head.next == null) return false;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("Meeting point : " + slow.data);
                return true;
            }
        }
        return false;
    }



    private static void detectLoopByFloydAndRemove(Node head) {
        if (head == null || head.next == null) return;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("Loop detected !");
                break;
            }
        }
        if (slow != fast)
            return;

        slow = head;
        while (slow.next !=  fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println("First Node of the Loop : " + slow.next.data);
        fast.next = null;
    }


    private static boolean detectLoop(Node head) {
        if (head == null || head.next == null) return false;

        Set<Node> set = new HashSet<>();
        Node curr = head;
        while (curr != null) {
            if (set.contains(curr))
                return true;
            else {
                set.add(curr);
                curr = curr.next;
            }
        }
        return false;
    }
}
