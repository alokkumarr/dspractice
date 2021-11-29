package dynamicprogramming;

public class CoinChangeProblem {

    /*
    We have supply of infinite number of coins, find a way to collect coins with given Sum.
     */
    public static void main(String[] args) {
        int[] coins = {2, 5, 3, 6};
        int sum = 10;
        // O/P - 5

        int noOfWays = selectCoins(coins, coins.length, sum);
        System.out.println("Number of ways : " + noOfWays);
    }

    private static int selectCoins(int[] coins, int n, int sum) {
        if (sum == 0) return 1;
        if (n == 0) return 0;
        int res = selectCoins(coins, n-1, sum);
        if (coins[n-1] <= sum) {
            res = res + selectCoins(coins, n, sum - coins[n-1]);
        }
        return res;
    }
}
