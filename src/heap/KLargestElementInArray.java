package heap;

import java.util.PriorityQueue;

public class KLargestElementInArray {
    public static void main(String[] args) {
        int[] arr = {5,15,10,20,8,25,18};
        int k = 3;
        largestElementInArray(arr, k);
    }

    private static void largestElementInArray(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
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
