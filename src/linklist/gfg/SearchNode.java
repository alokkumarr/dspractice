package linklist.gfg;

public class SearchNode {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20);
        node.next.next = new Node(30);
        int k = 30;
        int res = searchRec(node, k);
        System.out.println(res);
        System.out.println("-----------------");
    }

    private static int search(Node head, int ele) {
        if (head == null) return -1;

        int pos = 1;
        Node cur = head;
        while (cur != null) {
            if (cur.data == ele) {
                return pos;
            } else {
                pos ++;
                cur = cur.next;
            }
        }
        return -1;
    }

    private static int searchRec(Node head, int ele) {
        if (head == null) return -1;
        if (head.data == ele) return 1;
        else {
            int res = searchRec(head.next, ele);
            if (res == -1) return res;
            else return res +1;
        }
    }
}