package hashing.gfg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestOneAndZeros {
    public static void main(String[] args) {
        int[] arr = {0,0,0,1,0,1,1,0,0,1};
        int res = solutionBest(arr);
        System.out.println(res);
    }

    private static int solutionBest(int[] arr) {
        int res = 0;

        // convert all zeros to -1. then find the longest subarray with sum zero
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0)
                arr[i] = -1;
        }
        System.out.println(Arrays.toString(arr));

        // same solution for given sum
        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];
            if (preSum == 0)
                res = i + 1;

            if (!map.containsKey(preSum)) {
                map.put(preSum, i);
            }

            if (map.containsKey(preSum-0)) {
                res = Math.max(res, i - map.get(preSum-0));
            }
        }

        return res;
    }


    // Time - O(n^2), Space - O(1)
    private static int solutionNaive(int[] arr) {
        int res = 0;
        for(int i = 0; i < arr.length; i++) {
            int c0 =0, c1= 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == 0)
                    c0 ++;
                else
                    c1++;

                if (c0 == c1) {
                    res = Math.max(res, c0 + c1);
                }
            }
        }
        return res;
    }
}
