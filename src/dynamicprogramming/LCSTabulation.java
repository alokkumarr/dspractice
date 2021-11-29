package dynamicprogramming;

public class LCSTabulation {

    public static void main(String[] args) {
        String str1 = "abcmefabcd";
        String str2 = "fepabcd";
        int m = str1.length(), n = str2.length();
        int subLength = lcsTabulation(str1, str2);
        System.out.println(subLength);
    }

    // O(mn) - time complexity
    private static int lcsTabulation(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
