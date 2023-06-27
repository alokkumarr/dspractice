package arrays.gfg;

import java.util.Arrays;

public class LeftRotateByDPlaces {

    public static void main(String[] args) {
        int[] arr = {6, 12, 0, 4, 9, 0, 12, 11};
        leftRotateByD(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    private static void leftRotateByD(int[] arr, int d) {
        int n = arr.length-1;
        // reverse first d array
        reverse(arr, 0, d-1);

        // reverse first n-d array
        reverse(arr, n-d-1, n);

        // reverse complete array
        reverse(arr, 0, n);
    }

    private static void reverse(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
}
