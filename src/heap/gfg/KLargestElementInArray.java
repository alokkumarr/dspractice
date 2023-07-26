package heap.gfg;

import java.util.PriorityQueue;

public class KLargestElementInArray {

    /**
     * finnd the k largest element in an array.
     *
     * Solution 1st : Build a max binary tree and get poll/peek the top k item
     *                Time complexity - (n + klogn)
     *
     *
     * Solution 2nd: Best One
     *              : Build a min heap of k items. Now iterate over k+1 item and
     *              compare with the top if max then remove and add the item.
     *              Once the all item completed the min heap will have the kth
     *              largest items.
     *
     *              Time complexity : O(k+(n-k)logk)
     *
     */

    public static void main(String[] args) {
        int[] arr = {5,15,10,20,8,25,18};
        int k = 3;
        largestElementInArray(arr, k);
    }

    private static void largestElementInArray(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap

        for (int i = 0; i<k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k+1; i < arr.length; i++) {
            int top = pq.peek();
            if (arr[i] > top) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        System.out.println(pq);
    }
}
