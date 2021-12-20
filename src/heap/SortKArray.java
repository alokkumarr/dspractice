package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKArray {
    public static void main(String[] args) {
        int[] arr = {9,8,7,19,18};
        System.out.println(Arrays.toString(arr));
        int[] sortedArr = kthSortedArray(arr,3);
        System.out.println(Arrays.toString(sortedArr));
    }

    private static int[] kthSortedArray(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = 0;
        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k+1; i < n; i++) {
            arr[index++] = pq.poll();
            pq.add(arr[i]);
        }

        while (!pq.isEmpty())
            arr[index++] = pq.poll();

        return arr;
    }


}
