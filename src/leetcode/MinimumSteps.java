package leetcode;

public class MinimumSteps {

    public static void main(String[] args) {
        int n = 10;
        int[] memo = new int[n+1];
        int ans = countSteps(n, memo);
        System.out.println(ans);
    }

    private static int countSteps(int n, int[] memo) {
        if (n == 1)
            return 0;

        if (memo[n] > 0) {
            return memo[n];
        }
        // reduce by 1
        int ops1 = countSteps(n - 1, memo);
        int minStep = ops1;

        // divide by 2
        if (n % 2 == 0) {
            int ops2 = countSteps(n/2, memo);
            if (ops2 < minStep)
                minStep = ops2;
        }

        // divide by 3
        if (n % 3 == 0) {
            int ops3 = countSteps(n/3, memo);
            if (ops3 < minStep)
                minStep = ops3;
        }
        memo[n] = 1 + minStep;
        return 1 + minStep;
    }


}
