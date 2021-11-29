package arrays;

import java.util.Arrays;

public class ReverseAnArray {

    public static void main(String[] args) {
        int[] arr = {2,3,10,6,4,50,8,1};
        int[] result = reverseArray(arr);
        System.out.println("Result : " + Arrays.toString(result));
    }

    private static int[] reverseArray(int[] arr) {
        int low = 0, high = arr.length-1;
        while (low < high) {
            int tmp = arr[low];
            arr[low] = arr[high];
            arr[high] = tmp;
            low++;
            high--;
        }
        return arr;
    }
}
