package leetcode;

public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;

        // dyanamic problem template
        int dp[] = new int[nums.length + 1];
        dp[0] = 0; // zero house no robbery
        dp[1] = nums[0]; // first house max robbery

        for (int i = 1; i < nums.length; i++) {
            // look for dp table to get max robbery
            // dp[i-1] + nums[i]
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }

        // dp result always is last element
        return dp[nums.length];
    }
}
