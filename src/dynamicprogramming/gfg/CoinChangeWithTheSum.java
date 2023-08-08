package dynamicprogramming.gfg;

/*
Given a value sum, if we want to make change for sum cents, and we have an infinite supply
of each of coins[] = { coins1, coins2, .. , coinsn} valued coins, how many ways can we make the change?
The order of coins doesn't matter.

Examples:

Input: sum = 4, coins[] = {1,2,3},
Output: 4
Explanation: there are four solutions: {1, 1, 1, 1}, {1, 1, 2}, {2, 2}, {1, 3}.

Input: sum = 10, coins[] = {2, 5, 3, 6}
Output: 5
Explanation: There are five solutions:
{2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 */
public class CoinChangeWithTheSum {
    public static void main(String[] args) {
        int[] coins = {2, 5, 3, 6};
        int sum = 10;

        int coin = naiveCoinChange(coins, coins.length, sum);
        System.out.println("Number of coins : " + coin);
        
        coin = coinChangeByDP(coins, coins.length, sum);
        System.out.println(coin);
    }

    private static int coinChangeByDP(int[] coins, int n, int sum) {
        int[][] dp = new int[n+1][sum+1];

        // fill first column
        for (int i = 0; i <= n; i++) {
            dp[i][0]  =1;
        }

        // fill first row start from 1 st index onward
        for (int i = 1; i <= sum; i++) {
            dp[0][i]  = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if (coins[i-1] <= j) {
                    dp[i][j] += dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[n][sum];
    }

    private static int naiveCoinChange(int[] coins, int n, int sum) {
        if (sum == 0)
            return 1;
        if (sum < 0)
            return 0;
        if (n == 0)
            return 0;

        return naiveCoinChange(coins, n, sum - coins[n-1])
                + naiveCoinChange(coins, n-1, sum);
    }
}
