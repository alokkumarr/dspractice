package dynamicprogramming.gfg;

import java.util.Arrays;

/*
Given an array arr[] where each element represents the max number of steps
that can be made forward from that index. The task is to find the minimum number
of jumps to reach the end of the array starting from index 0. If the end isn’t
reachable, return -1.

Examples:

Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3 (1-> 3 -> 9 -> 9)
Explanation: Jump from 1st element to 2nd element as there is only 1 step.
Now there are three options 5, 8 or 9. I
f 8 or 9 is chosen then the end node 9 can be reached. So 3 jumps are made.

Input:  arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
Output: 10
Explanation: In every step a jump is needed so the count of jumps is 10.
 */
public class MinimumJump {
    public static void main(String[] args) {
        int[] arr = {3,4,2,1,2,1};
        int res = minimumJumpDP(arr, arr.length);
        System.out.println("Minimum Jump : " + res);
    }

    private static int minimumJump(int[] arr, int n) {
        if (n ==1) return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= n-2; i++) {
            if (arr[i] + i >= n-1) {
                int subRes = minimumJump(arr, i +1);
                if (subRes != Integer.MAX_VALUE) {
                    res = Math.min(subRes+1, res);
                }
            }
        }
        return res != Integer.MAX_VALUE ? res : -1;
    }

    private static int minimumJumpDP(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] + j >= i) {
                    if (dp[j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] +1);
                    }
                }
            }
        }

        return dp[n-1];
    }
}
