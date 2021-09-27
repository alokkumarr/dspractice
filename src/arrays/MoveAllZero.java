package arrays;

import java.util.Arrays;

public class MoveAllZero {
    public static void main(String[] args) {
        int[] arr = {1,0,0,4,5,0,7};
        System.out.println(Arrays.toString(arr));
    }

    private static int[] moveAllZero(int[] arr) {
        int countOfNonZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr, countOfNonZero, i);
                countOfNonZero++;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
