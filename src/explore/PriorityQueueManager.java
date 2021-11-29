package explore;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class PriorityQueueManager {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(12);
        pq.add(56);
        pq.add(98);
        pq.add(13);
        pq.add(5);
        pq.add(8);

        System.out.println(pq);
        System.out.println("-----------------------");

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(12, 3);
        map.put(56, 6);
        map.put(98, 7);
        map.put(13, 8);
        map.put(5, 9);
        map.put(8, 89);


        System.out.println(map);
    }
}
