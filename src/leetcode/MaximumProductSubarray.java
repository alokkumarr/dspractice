package leetcode;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int min = nums[0];
        int max = nums[0];
        int res = nums[0];

        // start from index 1 to length - 1
        for (int i = 1; i < n; i++) {
            int k = max * nums[i];
            int m = min * nums[i];

            max = Math.max(nums[i], Math.max(k, m));
            min = Math.min(nums[i], Math.min(k, m));

            res = Math.max(res, max);
        }
        return res;
    }

}
