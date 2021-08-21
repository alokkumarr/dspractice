package searching;

import java.util.Arrays;


// In binary search element always be sorted
//
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {10,20,30,40,50,60};
        int element = 30;
        System.out.println(Arrays.toString(array));
        int index = binaryRec(array, 0, array.length-1, element);
        System.out.println(index);
    }

    private static int binarySearch(int[] arr, int element) {
        int low = 0;
        int high = arr.length -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == element) {
                return mid;
            } else if (arr[mid] > element) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int binaryRec(int[] arr, int l, int r, int x) {

       if (l> r) return -1;
       int mid = (l + r)/2;
       if (arr[mid] == x) {
           return mid;
       } else if (arr[mid] > x) {
           return  binaryRec(arr, l, mid -1, x);
       } else {
           return binaryRec(arr, mid + 1, r, x);
       }
    }
}
