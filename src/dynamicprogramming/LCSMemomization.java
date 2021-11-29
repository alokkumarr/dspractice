package dynamicprogramming;

public class LCSMemomization {

    public static void main(String[] args) {
        String str1 = "abcmefabcd";
        String str2 = "fepabcd";
        int m = str1.length(), n = str2.length();

        int[][] memo = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        int subLength = lcsMemoization(str1, str2, m, n, memo);
        System.out.println(subLength);
    }

    private static int lcsMemoization(String str1, String str2, int m, int n, int[][] memo) {
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (m == 0 || n == 0) {
            memo[m][n] = 0;
        } else {
            if (str1.charAt(m-1) == str2.charAt(n-1)) {
                memo[m][n] = 1 + lcsMemoization(str1, str2, m-1, n-1, memo);
            } else {
                memo[m][n] = Math.max(lcsMemoization(str1, str2, m-1,n, memo),
                        lcsMemoization(str1, str2, m, n-1, memo));
            }
        }
        return memo[m][n];
    }
}
