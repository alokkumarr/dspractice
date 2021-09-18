package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestContiguousBinaryArrayWithEqual0Or1 {
    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1,0,1};
        int length = longestSubArrayNaiveSol(arr);
        System.out.println("Longest subarray of zero or one : " + length);

        length = longestSubArrayBestSol(arr);
        System.out.println("Longest subarray of zero or one with best : " + length);

    }

    /**
     * Replace every zero with the -1;
     * Find the sum of the longest array in zero;
     */
    private static int longestSubArrayBestSol(int[] arr) {
        int res = 0;
        for (int i = 0; i <arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];
            if (preSum == 0) {
                res = i + 1;
            }
            if (!map.containsKey(preSum)) {
                map.put(preSum, i);
            }
            if (map.containsKey(preSum)) {
                res = Math.max(res, i - map.get(preSum));
            }
        }
        return res;
    }


    private static int longestSubArrayNaiveSol(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int c1 = 0, c0 = 0;
            for (int j = i; j< arr.length; j++) {
                if (arr[j] == 1) c1++;
                if (arr[j] == 0) c0 ++;
                if (c1 == c0) {
                    res = Math.max(res, c1+c0);
                }
            }
        }
        return res;
    }

}
