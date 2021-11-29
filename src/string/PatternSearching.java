package string;

public class PatternSearching {
    public static void main(String[] args) {
        String pattern = "fgh";
        String text = "abcdeabcfgh";
        searchPatternNaiveImproved(text, pattern);
    }

    // if all the pattern are distinct
    // O(n) - moved m element hence order is n
    private static void searchPatternNaiveImproved(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        for (int i = 0; i < n - m + 1;) {
            int j;
            for (j = 0; j < m; j++) {
                if (pattern.charAt(j) != text.charAt(j + i))
                    break;
            }
            if (j == m) System.out.println(i);
            if (j == 0) i++;
            else i = i+j;
        }
    }

    // O(n-m+1)*m
    private static void searchPatternNaive(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        for (int i = 0; i<n-m+1; i++) {
            int j;
            for (j=0;j<m;j++) {
                if (pattern.charAt(j) != text.charAt(j+i))
                    break;
            }
            if (j == m) System.out.println(i);
        }
    }
}
