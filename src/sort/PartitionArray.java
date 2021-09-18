package sort;

import java.util.Arrays;

public class PartitionArray {

    public static void main(String[] args) {
        int[] array = {5, 3, 12, 8, 5};
        int pivot = naivePartition(array, 0, array.length-1, 0);
        System.out.println("Pivot elements : " + pivot);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Time complexity - O(n)
     * Space Complexity = O(n)
     */
    private static int naivePartition(int[] arr, int l, int h, int piv) {
        int[] temp = new int[h-l+1];
        int index = 0;
        // smaller elements
        for (int i = l; i <= h; i++) {
            if (arr[i] < arr[piv]){
                temp[index] = arr[i];
                index++;
            }
        }

        // equals elements
        for (int i = l; i <= h; i++) {
            if (arr[i] == arr[piv]){
                temp[index] = arr[i];
                index++;
            }
        }

        // last occurrence
        int res = l + index -1;

        // greater elements
        for (int i = l; i <= h; i++) {
            if (arr[i] > arr[piv]){
                temp[index] = arr[i];
                index++;
            }
        }

        // copy array to original
        for (int i = l; i <= h; i++) {
            arr[i] = temp[i-l];
        }
        return res;
    }
}
