package arrays.gfg;

import java.util.Arrays;

public class RemoveDuplicateSorted {

    public static void main(String[] args) {
        int[] arr = {12,12,12,14};
        int result = removeDuplicateSorted(arr);
        System.out.println("Result sorted : " + result);
        System.out.println(Arrays.toString(arr));

    }

    private static int removeDuplicateSorted(int[] arr) {
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                arr[res] = arr[i];
                res++;
            }
        }
        for (int i = res; i < arr.length; i++) {
            arr[i] = 0;
        }
        //System.out.println(Arrays.toString(arr));
        return res;
    }


    private static int largestSecond(int[] arr) {
        int res = -1, largest = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[largest]) {
                res = largest;
                largest = i;
            } else if (arr[i] != arr[largest]){
                if (res == -1 || arr[i] > arr[largest])
                    res = i;
            }
        }
        return res;
    }
}
