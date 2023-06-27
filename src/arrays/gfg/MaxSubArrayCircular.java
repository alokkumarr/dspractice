package arrays.gfg;

public class MaxSubArrayCircular {
    public static void main(String[] args) {
        int[] arr = {5,-2,3,4};

        int maxSumSubArray = findMaxSubarray(arr);
        System.out.println(maxSumSubArray);
    }

    /**
     * Aproach is find the prev max and add curr to get the max data
     */
    private static int findMaxSubarrayBest(int[] arr) {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
             res = Math.max(res + arr[i], arr[i]);
        }
        return  res;
    }

    // {5,-2,3,4};
    private static int findMaxSubarray(int[] arr) {
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int currMax = arr[i];
            int currSum = arr[i];
            for (int j = 1; j < arr.length; j++) {
                int index = (i+j) % arr.length;
                currSum += arr[index];
                currMax = Math.max(currSum, currMax);
            }
            res = Math.max(res, currMax);
        }
        return res;
    }
}
