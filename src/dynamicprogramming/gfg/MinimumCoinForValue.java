package dynamicprogramming.gfg;

import java.util.Arrays;

/*
Given a value V, if we want to make a change for V cents, and we have an infinite supply of each of C = { C1, C2, .., Cm}
valued coins, what is the minimum number of coins to make the change? If it's not possible to make a change, print -1.

Examples:

Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required We can use one coin of 25 cents and one of 5 cents

Input: coins[] = {9, 6, 5, 1}, V = 11
Output: Minimum 2 coins required We can use one coin of 6 cents and 1 coin of 5 cents

This problem is a variation of the problem discussed Coin Change Problem.
Here instead of finding the total number of possible solutions, we need to find the solution with the minimum number of coins.
 */
public class MinimumCoinForValue {
    public static void main(String[] args) {
        int[] coins = {25, 10, 5};
        int val = 30;

        int min = minCoinsDP(coins, coins.length, val);
        System.out.println(min);
    }

    private static int minCoins(int[] coins, int n, int val) {
        if (val == 0)
            return 0;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (coins[i] <= val) {
                int tempResult = minCoins(coins, n, val - coins[i]);
                if (tempResult != Integer.MAX_VALUE)
                    res = Math.min(res, tempResult + 1);
            }
        }
        return res;
    }

    private static int minCoinsDP(int[] coins, int n, int val) {
        int[] dp = new int[val+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // where value is 0 then min coin is 0
        dp[0] = 0;

        for (int i = 1; i <= val; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                     int subRes = dp[i - coins[j]];
                     if (subRes != Integer.MAX_VALUE & subRes+1 < dp[i]) {
                         dp[i] = subRes+1;
                     }
                }
            }
        }
        return dp[val];
    }
}
