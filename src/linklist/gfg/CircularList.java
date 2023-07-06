package linklist.gfg;

public class CircularList {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20);
        node.next.next = new Node(30);
        node.next.next.next = node;



        Node p = node;
        do {
            System.out.print(p.data + " ");
            p = p.next;
        } while (p != node);
    }
}
