package arrays;

import java.util.HashMap;
import java.util.Map;

public class FindMissingDuplicate {
    public static void main(String[] args) {
        int[] arr = {-1, -1, -2};
        int missing = singleNumber(arr);
        System.out.println(missing);
    }

    public static int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        Map<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(hmap.containsKey(hmap.get(nums[i]))) {
                hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
            } else {
                hmap.put(nums[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry: hmap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return 0;
    }
}
