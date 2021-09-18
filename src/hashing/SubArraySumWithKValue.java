package hashing;

import java.util.HashSet;
import java.util.Set;

public class SubArraySumWithKValue {
    public static void main(String[] args) {
        int[] arr = {2,3,4,6};
        int sum = 9;
        boolean haveSubArray = isSubArraySumNaive(arr, sum);
        System.out.println("Subarray Exist by naive: " + haveSubArray);
        haveSubArray = isSubArraySumBestSol(arr, sum);
        System.out.println("Subarray Exist : " + haveSubArray);
    }

    private static boolean isSubArraySumBestSol(int[] arr, int sum) {
        Set<Integer> set = new HashSet<>();
        int preSum = 0;
        for (int data : arr) {
            preSum += data;
            if (preSum == sum) return true;
            if (set.contains(preSum-sum)) return true;
            set.add(data);
        }
        return false;
    }

    // O(n^2)
    // O(1)
    private static boolean isSubArraySumNaive(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            int tempSum = 0;
            for (int j = i; j < arr.length; j++) {
                tempSum = tempSum + arr[j];
                if (tempSum == sum) {
                    System.out.println("Subarray start :" + i + " and end : " + j);
                    return true;
                }
            }
        }
        return false;
    }
}
