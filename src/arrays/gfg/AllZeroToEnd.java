package arrays.gfg;

import java.util.Arrays;

public class AllZeroToEnd {

    public static void main(String[] args) {
        int[] arr = {6,12,0,0, 0, 4, 9, 0, 12, 11};
        allZeroToEnds(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void allZeroToEnds(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int tmp = arr[i];
                arr[i] = arr[count];
                arr[count] = tmp;
                count++;
            }
        }
    }

    private static void swap(int[] arr, int i, int count) {
        int tmp = arr[i];
        arr[i] = arr[count];
        arr[count] = tmp;
    }

}
