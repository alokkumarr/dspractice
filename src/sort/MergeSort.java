package sort;

import java.util.Arrays;

/**
 * 1) Divide and conquer Algo
 * 2) Stable Algo
 * 3) O(nlogn) time and O(n) aux
 * 4) Wells Suited for linked list
 * 5) Used in external Sorting
 * 6) In general QuickSort for array outperformed
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {10, 5, 30, 15, 7};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] a, int l, int r) {
        if(r > l) {
            int m = l + (r - l) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m+1, r);
            merge(a, l, m, r);
        }
    }

    public static void merge(int a[], int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i = 0; i < n1; i++){
            left[i] = a[low + i];
        }

        for(int i = 0; i < n2; i++){
            left[i] = a[mid + i + 1];
        }

        int i =0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i ++; k++;
            } else {
                a[k] = right[j];
                j ++; k++;
            }
        }

        while (i < n1) {
            a[k] = left[i];
            i ++; k++;
        }

        while (j < n2) {
            a[k] = right[j];
            j ++; k++;
        }

    }
}
