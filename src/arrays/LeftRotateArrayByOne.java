package arrays;

import java.util.Arrays;

public class LeftRotateArrayByOne {
    public static void main(String[] args) {
        int[] arr = {1,0,0,4,5,0,7};
        //System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(leftRotate(arr)));
    }

    private static int[] leftRotate(int[] arr) {
        int element = arr[0];
        for (int i = 1; i < arr.length; i++) {
            swap(arr, i, i-1);
        }
        arr[arr.length-1] = element;
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
