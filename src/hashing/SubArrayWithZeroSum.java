package hashing;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = {-3,1,2,5};
        int sum = 0;
        boolean haveSubArray = isSubArraySumZeroNaive(arr, sum);
        System.out.println("Subarray Exist by Naive : " + haveSubArray);
        haveSubArray = isSubArraySumZeroBestSol(arr, sum);
        System.out.println("Subarray Exist : " + haveSubArray);
    }

    private static boolean isSubArraySumZeroNaive(int[] arr, int sum) {
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

    private static boolean isSubArraySumZeroBestSol(int[] arr, int sum) {
        Set<Integer> set = new HashSet<>();
        int preSum = 0;
        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];
            if (set.contains(preSum)) return true;
            if (preSum == 0) return true;
            set.add(preSum);
        }
        return false;
    }
}
