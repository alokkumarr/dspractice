package leetcode;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] > max) {
                    max = dp[j];
                }
            }

            dp[i] = max + 1;

            if (dp[i] > res)
                res = dp[i];
        }
        return res;
    }


}
