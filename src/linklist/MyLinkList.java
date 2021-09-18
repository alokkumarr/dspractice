package linklist;

public class MyLinkList {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = new Node(40);
        // insert node at start
        /*Node newHead = insertNodeAtStart(head, 5);
        traverseListRec(newHead);

        System.out.print("\n------------------\n");
        // insert node at end
        Node newHead1 = insertNodeAtEnd(head, 50);
        traverseListRec(newHead1);

        System.out.print("\n------------------\n");
        // delete node at start
        Node deleteList = deleteNodeAtStart(head);
        traverseListRec(deleteList);

        System.out.print("\n------------------\n");
        // delete node at end
        Node deleteEndList = deleteNodeAtEnd(head);
        traverseListRec(deleteEndList);*/

        System.out.print("\n------------------\n");
        // insert at Kth position
        Node insertAtKthPosition = insertNodeAtKthPosition(head, 12, 2);
        traverseListRec(insertAtKthPosition);
        System.out.print("\n------------------\n");

        int index = searchIndexRec(insertAtKthPosition, 10);
        System.out.println(index);
    }

    static int searchIndexRec(Node head, int data) {
        if (head == null) return -1;
        if (head.data == data) return 1;
        else {
            int res = searchIndexRec(head.next, data);
            if (res == -1) return -1;
            else {
                return res+1;
            }
        }
    }

    static int findIndex(Node head, int data) {
        int pos = 1;
        if (head == null) return -1;
        Node curr = head;
        while (curr != null) {
            if (curr.data == data) {
                return pos;
            } else {
                pos++;
                curr = curr.next;
            }
        }
        return -1;
    }

    private static Node insertNodeAtKthPosition(Node head, int data, int pos) {
        Node tmp = new Node(data);
        // check if its a first element
        if (pos == 1) {
            tmp.next = head;
            return tmp;
        }

        // find the position of previous node
        Node curr = head;
        for (int i = 1; i <= pos-2; i++) {
            curr = curr.next;
        }

        // check if its matches the last element
        if (curr == null) return head;

        tmp.next = curr.next;
        curr.next = tmp;

        return head;
    }


    private static Node deleteNodeAtEnd(Node head) {
        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    private static Node deleteNodeAtStart(Node head) {
        if (head == null) return null;
        if (head.next == null) return null;
        return head.next;
    }

    // traversal with recursion
    static void traverseListRec(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + "->");
        traverseListRec(head.next);
    }

    // traverse with iteration
    static void printList(Node node) {
        Node head = node;
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
    }

    // insert am element at start
    static Node insertNodeAtStart(Node head, int data) {
        Node temp = new Node(data);
        temp.next = head;
        return temp;
    }

    // insert am element at start
    static Node insertNodeAtEnd(Node head, int data) {
        Node tmp = new Node(data);
        if (head == null) return tmp;
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = tmp;
        return head;
    }
}

