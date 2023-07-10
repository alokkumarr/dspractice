package linklist.gfg;

import java.util.HashSet;
import java.util.Set;

public class IntersectionPoint {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.next = new Node(20);
        node.next.next = new Node(30);
        node.next.next.next = new Node(35);
        node.next.next.next.next = new Node(40);
        node.next.next.next.next.next = new Node(45);

        Node node2 = new Node(15);
        node2.next = new Node(28);
        node2.next.next = new Node(30);


        PrintList.printList(node);
        System.out.println();
        PrintList.printList(node2);
        System.out.println();
        int point = findIntersectionPoint(node, node2);
        System.out.println(point);
    }



    // O(m+n) - time
    private static int findIntersectionPoint(Node node1, Node node2) {
        if (node1 == null || node2 == null) return -1;

        Set<Integer> set = new HashSet<>();
        while (node1 != null) {
            set.add(node1.data);
            node1 = node1.next;
        }
        while (node2 != null) {
            if (set.contains(node2.data))
                return node2.data;
            node2 = node2.next;
        }
        return -1;
    }


}
