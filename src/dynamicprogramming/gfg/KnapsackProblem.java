package dynamicprogramming.gfg;

/*
0-1 knapsack problem

Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value
 in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values
  and weights associated with n items respectively. Also given an integer W which represents knapsack capacity,
   find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
You cannot break an item, either pick the complete item or don't pick it (0-1 property).
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] val = {10, 40, 30, 50};
        int[] weight = {5, 4, 6, 3};
        int W = 10;

        int result = knapSackDP(W, val, weight, val.length);
        System.out.println(result);
    }

    private static int knapSack(int W, int[] val, int[] wt, int n) {
        if (n == 0 || W == 0)
            return 0;

        if (wt[n-1] > W) {
            return knapSack(W, val, wt, n-1);
        } else {
            return Math.max(knapSack(W, val, wt, n-1),
                    val[n-1] + knapSack(W-wt[n-1], val, wt, n-1));
        }
    }


    private static int knapSackDP(int W, int[] val, int[] wt, int n) {
        int[][] dp = new int[n+1][W+1];
        // fill first row
        for (int i = 0; i <= W; i++) {
            dp[0][i] = 0;
        }

        // fill first column
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
           for (int j = 1; j <= W; j++) {
               if (wt[i-1] > j) {
                   dp[i][j] = dp[i-1][j];
               } else {
                   dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
               }
           }
        }

        return dp[n][W];
    }
}
