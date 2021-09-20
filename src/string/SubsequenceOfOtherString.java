package string;

public class SubsequenceOfOtherString {

    public static void main(String[] args) {
        String str1 = "geeksforgeeks";
        String str2 = "grges";
        System.out.println(subSequences(str1, str2));
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
}
