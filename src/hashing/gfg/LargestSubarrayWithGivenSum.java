package hashing.gfg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestSubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {8,3,1,5,-6,6,2,2};
        int sum = 4;
        int res = subarray(arr, sum);
        System.out.println(res);
    }

    private static int subarray(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int preSum = 0;
        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];
            if (preSum == sum)
                 res = i + 1;

            if (!map.containsKey(preSum)) {
                map.put(preSum, i);
            }

            if (map.containsKey(preSum - sum)){
                res = Math.max(res, i - map.get(preSum-sum));
            }

        }

        return res;
    }
}
