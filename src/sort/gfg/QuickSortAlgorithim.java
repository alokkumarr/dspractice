package sort.gfg;

import java.util.Arrays;

public class QuickSortAlgorithim {
    public static void main(String[] args) {
        int[] arr = {8,4,7,9,3,10,5};
        quickSortWithLomuto(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSortWithHoars(int[] arr, int l, int h) {
        if (l < h) {
            int p = partitionHoars(arr, l, h);
            quickSortWithHoars(arr,l,p-1);
            quickSortWithHoars(arr,p+1, h);
        }
    }

    private static int partitionHoars(int[] arr, int l, int h) {
        return 0;
    }


    private static void quickSortWithLomuto(int[] arr, int l, int h) {
        if (l < h) {
            int p = partitionLomuto(arr, l, h);
            quickSortWithLomuto(arr,l,p-1);
            quickSortWithLomuto(arr,p+1, h);
        }
    }

    private static int partitionLomuto(int[] arr, int l, int h) {
        int i = l - 1;
        int pivot = arr[h]; // always last element

        for (int j = l; j<=h-1; j++) {
            if (arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, h);
        return i+1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
