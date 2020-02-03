package arrays;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] a = {-5, 4, 6, -3, 4, -1};
        System.out.println(maxSubArray(a));
    }

    private static int maxSubArray(int[] arr) {
        int maxSum = 0, curSum = 0 ;
        int start = 0, end = 0;
        for (int j : arr) {
            curSum = curSum + j;
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            if (curSum < 0) curSum = 0;
        }
        return maxSum;
    }

    private static int maxSubArraySol2(int[] arr) {
        int maxEndHere = 0, maxSoFar = Integer.MIN_VALUE;
        // [-2, -3, 4, -1, -2, 1, 5, -3]
        for (int j : arr){
            maxEndHere = maxEndHere + j;
            if (maxEndHere < j) maxEndHere = j;
            if (maxSoFar < maxEndHere) maxSoFar = maxEndHere;
        }
        return maxSoFar;
    }
}
