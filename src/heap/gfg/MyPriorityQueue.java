package heap.gfg;
import java.util.Collections;
import java.util.PriorityQueue;

public class MyPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(30);
        pq.add(20);
        pq.add(3);


        System.out.println(pq.peek());
    }
}
