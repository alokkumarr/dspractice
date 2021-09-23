package hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestContiguousArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {3,9,2,-3,5,6,-1,4};
        int sum = 11;
        int length = longestSubArraySumNaive(arr, sum);
        //System.out.println("Maximum length : " + length);
        length = longestSubArraySumBest(arr, sum);
        System.out.println("Maximum length with best solution : " + length);
    }

    private static int  longestSubArraySumNaive(int[] arr, int sum) {
        int res = 0;
        for (int i = 0 ; i < arr.length; i++) {
            int currSum = 0;
            for (int j = i; j < arr.length; j++) {
                currSum += arr[j];
                if (currSum == sum) {
                    res = Math.max(res, j-i+1);
                }
            }
        }
        return res;
    }

    //{3,9,2,-3,5,6,-1,4};
    private static int longestSubArraySumBest(int[] arr, int sum) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];
            if (preSum == sum) {
                res = i + 1;
            }
            if (!map.containsKey(preSum)) {
                map.put(preSum, i);
            }
            if (map.containsKey(preSum - sum)) {
                res = Math.max(res, i - map.get(preSum-sum));
            }
        }
        return res;
    }
}
