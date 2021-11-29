package linklist;

public class ReverseListInKGroup {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(25);
        Node temp3 = new Node(30);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = new Node(40);

        traverse(head);
        Node newList = reverseLinkListIteration(head, 3);
        System.out.println();
        traverse(newList);
    }

    private static Node reverseLinkListIteration(Node head, int k) {
        Node curr = head, prevFirst = null;
        boolean isFirstPass = true;
        while (curr != null) {
            Node first = curr;

            Node prev = null;
            int count = 0;
            while (curr != null && count < k) {
                Node currNext = curr.next;
                curr.next = prev;
                prev = curr;
                curr = currNext;
                count++;
            }

            // check the first pass
            if (isFirstPass) {
                head = prev;
                isFirstPass = false;
            } else {
                prevFirst.next = prev;
            }
            prevFirst = first;
        }
        return head;
    }


    private static Node reverseLinkListRecursion(Node head, int k) {
        if (head == null) return null;
        Node prev = null;
        Node curr = head;
        Node currNext = null;
        int count = 0;
        while (curr != null && count < k) {
            currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currNext;
            count++;
        }

        // this is to make sure to add next element of kth group
        // recursive call
        if (currNext != null) {
            head.next = reverseLinkListRecursion(currNext, k);;
        }
        return prev;
    }


    static void traverse(Node head) {
        if (head == null) return;
        System.out.print(head.data + " -> ");
        traverse(head.next);
    }
}
