package string;

public class SubsequenceOfOtherString {

    public static void main(String[] args) {
        String str1 = "geeksforgeeks";
        String str2 = "grgtes";
        System.out.println(isSubSequence(str1, str2, str1.length()-1, str2.length()-1));
    }

    // O (m+n)
    // Aux Space ~ O(1)
    static boolean subSequences(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        if (n < m) return false;
        int j = 0;
        for (int i = 0; i < n && j < m; i++) {
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
        }
        return (j == m);
    }

    static boolean isSubSequence(String st1, String str2, int m, int n) {
        if (n == 0) return true;
        if (m == 0) return false;
        if (st1.charAt(m) == str2.charAt(n)) {
            return isSubSequence(st1, str2, m-1, n-1);
        } else {
            return isSubSequence(st1, str2, m-1, n);
        }
    }
}
