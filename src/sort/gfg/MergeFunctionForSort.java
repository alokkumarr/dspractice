package sort.gfg;

import java.util.Arrays;

public class MergeFunctionForSort {
    public static void main(String[] args) {
        int[] arr = {10,15,20,40,8,11,55};
        int l = 0, mid = arr.length/2, h = arr.length - 1;
        //merge(arr, l, mid, h);
        mergeSort(arr, l, h);
        //System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int l , int r) {
        if (r > l) {
            int mid = l + (r-l)/2;
            mergeSort(arr, l, mid);
            System.out.println(Arrays.toString(arr));
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int h) {
        int m = mid - l + 1, n = h - mid;
        int[] left = new int[m];
        int[] right = new int[n];

        System.arraycopy(arr, l, left, 0, m);

        for (int i = 0; i < n; i++)
            right[i] = arr[mid+i+1];

        int i = 0, j = 0, k = l;
        while (i < m && j < n) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++; k++;
            } else {
                arr[k] = right[j];
                j++; k++;
            }
        }

        while (i < m) {
            arr[k] = left[i];
            i++;
        }

        // print second array element
        while (j< n) {
            arr[k] = left[j];
            j++;
        }
    }
}
