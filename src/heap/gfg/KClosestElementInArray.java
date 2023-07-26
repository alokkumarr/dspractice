package heap.gfg;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestElementInArray {

    /**
     * finnd the k closest element in an array.
     *
     * Solution  : Build a max binary tree and get poll/peek the top k item
     *                Time complexity - (n + klogn)
     *
     */

    public static void main(String[] args) {
        int[] arr = {5,15,10,20,8,25,18};
        int k = 3;
        int element = 18;
        closestElementInArray(arr, k,element);
    }

    private static void closestElementInArray(int[] arr, int k, int item) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair::getValue));


        for (int i = 0; i<k; i++) {
            pq.add(new Pair(arr[i], Math.abs(item-arr[i])));
        }

        for (int i = k+1; i < arr.length; i++) {
            Pair top = pq.peek();
            int diff = Math.abs(arr[i] - item);
            if (top != null && top.getValue() > diff) {
                pq.poll();
                pq.add(new Pair(arr[i], diff));
            }
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll().key + " ");
        }
    }
}

class Pair
{
    Integer key;
    Integer value;

    public Pair(Integer key, Integer value)
    {
        this.key = key;
        this.value = value;
    }
    public Integer getKey()
    {
        return key;
    }
    public void setKey(Integer key)
    {
        this.key = key;
    }
    public Integer getValue()
    {
        return value;
    }
    public void setValue(Integer value)
    {
        this.value = value;
    }
}
