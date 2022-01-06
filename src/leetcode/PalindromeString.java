package leetcode;

public class PalindromeString {

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int count = 0;

        // first loop for gap between the string
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
                if (dp[i][j])
                    count++;

            }
        }

        return count;
    }
}
