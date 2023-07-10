package linklist.gfg;

public class ReverseList {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20);
        node.next.next = new Node(30);
        node.next.next.next = new Node(35);
        node.next.next.next.next = new Node(40);
        node.next.next.next.next.next = new Node(45);

        //PrintList.printListRecursion(node);
        //System.out.println();
        //Node res = reverseRecursive(node, null);
        //PrintList.printListRecursion(res);
        //System.out.println();

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(20);
        head.next.next.next = new Node(30);
        head.next.next.next.next = new Node(30);
        head.next.next.next.next.next = new Node(30);

        PrintList.printListRecursion(node);
        System.out.println();
        Node result = reverseInGroup(node, 2);
        PrintList.printListRecursion(result);
    }


    private static Node reverseInGroup(Node head, int k) {
        if (head == null) return head;

        boolean isFirstHead = true;
        Node curr = head, prevFirst = null;
        while (curr != null) {
            int count = 0;
            Node first = curr, prev=null;
            while (curr != null && count < k) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }

            if (isFirstHead) {
                head = prev;
                isFirstHead = false;
            } else {
                prevFirst.next = prev;
            }
            prevFirst = first;
        }
        return head;
    }

        private static Node reverseInGroupRec(Node head, int k) {
        if (head == null) return head;

        int count = 0;

        Node curr = head, prev = null, next = null;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (next != null) {
            head.next = reverseInGroupRec(next, k);
        }

        return prev;
    }



    private static Node removeDuplicate(Node head) {
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }


    private static Node reverse(Node head) {
        if (head == null) return null;

        Node curr = head, prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


    private static Node reverseRecursive(Node head, Node prev) {
        if (head == null) return prev;
        Node next = head.next;
        head.next = prev;
        prev = head;
        return reverseRecursive(next, prev);
    }
}
