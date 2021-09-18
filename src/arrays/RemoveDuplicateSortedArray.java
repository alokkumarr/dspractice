package arrays;

import java.util.Arrays;

public class RemoveDuplicateSortedArray {
    public static void main(String[] args) {
        int[] arr = {10,20,20,30,30,30,40};
        int res1 = naiveSolution(arr);
        System.out.println(res1);
        int[] arr1 = {10,20,20,30,30,30,40};
        int res = bestSolution(arr1);
        System.out.println("Best Solution : " + res);
    }

    private static int bestSolution(int[] arr) {
        int res = 1;
        for (int i = 1; i < arr.length; i++){
            if (arr[i] != arr[res-1]) {
                arr[res] = arr[i];
                res++;
            }
        }

        for (int i = res; i < arr.length; i++){
            arr[i] = 0;
        }

        System.out.println(Arrays.toString(arr));
        return res;
    }

    private static int naiveSolution(int[] arr) {
        int[] temp = new int[arr.length];
        //System.out.println(arr.length);
        temp[0] = arr[0];
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            if (temp[res-1] != arr[i]) {
                temp[res] = arr[i];
                res++;
            }
        }

        for (int i = 0; i < res; i++) {
            arr[i] = temp[i];
        }

        System.out.println(Arrays.toString(temp));

        return res;
    }
}
