package arrays;

import java.util.Arrays;

public class RemoveDuplicatesArray {

    public static void main(String[] args) {
        int[] arr = {10,10,30,20,20,24};
        int[] result = removeDuplicate(arr);
        System.out.println("Result : " + Arrays.toString(result));
    }

    private static int[] removeDuplicate(int[] arr) {
        int index = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[index-1]) {
                arr[index] = arr[i];
                index ++;
            }
        }
        for (int i = index; i < arr.length; i++ ) {
            arr[i] = 0;
        }
        return arr;
    }
}
