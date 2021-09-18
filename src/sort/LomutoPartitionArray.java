package sort;

import java.util.Arrays;

public class LomutoPartitionArray {

    public static void main(String[] args) {
        int[] array = {5, 3, 12, 8, 1, 2, 4};
        //swap(array, 2,3);
        System.out.println(Arrays.toString(array));

        int pivot = lumutoPartition(array, 0, array.length-1);
        System.out.println("Pivot elements : " + pivot);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Time complexity - O(n)
     * Space Complexity = O(1 )
     */
    private static int lumutoPartition(int[] arr, int l, int h) {
        int piv = arr[h];
        int i = l-1;

        for (int j = l; j <= h -1; j++) {
            if (arr[j] < piv) {
                i ++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1, h);
        return i+1;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
}
