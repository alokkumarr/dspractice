package string.gfg;

public class Anagram {

    // anagram mean if both the string have same charecter in both the string
    public static void main(String[] args) {
        String str = "ADBC";
        String s1 = "ABDC";

        boolean res = isSolution(str, s1);
        System.out.println(res);
    }


    // iterative solution
    private static boolean isSolution(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        //check if m is gteater then no solution
        if (n != m) return false;

        //
        int[] count = new int[26];

        for (int i = 0; i<n; i++) {
            count[s1.charAt(i)-'A']++;
            count[s2.charAt(i)-'A']--;
        }

        for (int i = 0; i<n; i++) {
            if (count[i] != 0)
                return false;
        }
        return true;
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





}
