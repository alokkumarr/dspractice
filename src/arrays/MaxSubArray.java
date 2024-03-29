package arrays;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        //{-5, 4, 6, -3, -4, -1};
        System.out.println(maxSubArraySol2(a));
    }

    private static int maxSubArraySol2(int[] arr) {
        int maxEndHere = 0;
        int result = Integer.MIN_VALUE;
        for (int i : arr){
            maxEndHere = Math.max(maxEndHere + i, i);
            result = Math.max(maxEndHere, result);
        }
        return result;
    }





    private static int maxSubArray(int[] arr) {
        int maxSum = 0, curSum = 0 ;
        for (int j : arr) {
            curSum = curSum + j;
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            if (curSum < 0) curSum = 0;
        }
        return maxSum;
    }

}
