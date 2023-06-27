package arrays.gfg;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-3, 8, -2, 4, -5, 6};

        int maxSumSubArray = findMaxSubarrayBest(arr);
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


    private static int findMaxSubarray(int[] arr) {
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int curr = 0;
            for (int j = i; j < arr.length; j++) {
                curr += arr[j];
                res = Math.max(res, curr);
            }
        }
        return res;
    }
}
