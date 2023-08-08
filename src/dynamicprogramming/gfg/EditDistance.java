package dynamicprogramming.gfg;

/*
Given two strings str1 and str2 and below operations that can be performed on str1.
Find minimum number of edits (operations) required to convert 'str1' into 'str2'.

1) Insert
2) Remove
3) Replace

All of the above operations are of equal cost.
 */
public class EditDistance {
    public static void main(String[] args) {
        String s1 = "SATURDAY";
        String s2 = "SUNDAY";

        int distance = editDistance(s1, s2, s1.length(), s2.length());
        System.out.println(distance);


        distance = editDistanceDP(s1, s2, s1.length(), s2.length());
        System.out.println("Solution by Dynamic Problem : " + distance);
    }

    private static int editDistanceDP(String s1, String s2, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        // fill row with 0 to m
        for(int i = 0; i <= m; i++)
            dp[i][0] = i;

        // fill column with 0 to m
        for(int i = 0; i <= n; i++)
            dp[0][i] = i;


        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1+ Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1]));
            }
        }
        return dp[m][n];
    }

    private static int editDistance(String s1, String s2, int m, int n) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;

        if (s1.charAt(m-1) == s2.charAt(n-1)) {
            return editDistance(s1, s2, m-1, n-1);
        } else {
            return 1+ Math.min(Math.min(editDistance(s1, s2, m, n-1), editDistance(s1, s2, m-1, n)),
            editDistance(s1, s2, m-1, n-1));

        }

    }
}
