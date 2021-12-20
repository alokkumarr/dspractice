package dynamicprogramming;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String str1 = "abcmefabcd";
        String str2 = "fepabcd";

        int subLength = longestCommonSubString(str1, str2, str1.length(), str2.length());
        System.out.println(subLength);
    }

    private static int longestCommonSubString(String str1, String str2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (str1.charAt(m-1) == str2.charAt(n-1)) {
            return 1 + longestCommonSubString(str1, str2, m-1, n-1);
        } else {
            return Math.max(longestCommonSubString(str1, str2, m-1, n),
                    longestCommonSubString(str1, str2, m, n-1));
        }

    }
}
