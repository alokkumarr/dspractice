package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums)
            map.put(num, true);

        for (int i = 0; i <= nums.length; i++) {
            if (map.containsKey(nums[i] - 1 ))
                map.put(nums[i], false);
        }

        int max = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key)) {
                max = Math.max(max, findLength(map, key));
            }
        }
        return max;
    }


    private static int findLength(Map<Integer, Boolean> hm, int k) {
        int ans = 0;
        while (hm.containsKey(k)) {
            ans++;
            k++;
        }
        return ans;
    }
}
