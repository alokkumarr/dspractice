package sort;

import java.util.Arrays;

public class HoarePartitionArray {

    public static void main(String[] args) {
        int[] array = {5, 3, 8, 4, 2, 7, 1, 10};
        //swap(array, 2,3);
        System.out.println(Arrays.toString(array));

        int pivot = hoarePartition(array, 0, array.length-1);
        System.out.println("Pivot elements : " + pivot);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Time complexity - O(n)
     * Space Complexity = O(1)
     */
    private static int hoarePartition(int[] arr, int l, int h) {
        int piv = arr[l];
        int i = l-1, j = h +1;
        while (true) {
            do {
                i ++;
            } while (arr[i] < piv);
            do {
                j--;
            } while (arr[j] > piv);
            if (i >= j) return j;
            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
}
