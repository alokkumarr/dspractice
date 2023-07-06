package string.gfg;

public class CheckStringIsSubsequenceOfOther {

    public static void main(String[] args) {
        String str = "ADBC";
        String s1 = "AB";

        boolean res = isSolutionRecursive(str, s1, str.length()-1, s1.length()-1);
        System.out.println(res);
    }

    // recursive solution
    private static boolean isSolutionRecursive(String s1, String s2, int n, int m) {
        if (m == 0)
            return true;
        if (n == 0)
            return false;
        if (s1.charAt(n) == s2.charAt(m))
            return isSolutionRecursive(s1, s2, n-1, m-1);
        else
            return isSolutionRecursive(s1, s2, n-1, m);
    }


    // iterative solution
    private static boolean isSolution(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        //check if m is gteater then no solution
        if (n < m) return false;

        int j = 0;
        for (int i = 0; i<n && j<m; i++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
        }

        return j==m;
    }


}
