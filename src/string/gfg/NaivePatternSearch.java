package string.gfg;

public class NaivePatternSearch {
    public static void main(String[] args) {
        String text = "abcefgabcd";
        String patt = "abcd";

        boolean isMatched = improvedNaiveMatch(text, patt);
        System.out.println("isMatched : " + isMatched);

    }

    private static boolean naiveMatch(String text, String patt) {
        int n = text.length();
        int m = patt.length();

        for(int i = 0; i <= n-m; i++) {
            int j;
            for (j = 0; j<m;j++) {
                if (patt.charAt(j) != text.charAt(i+j)) {
                    break;
                }
            }

            if (j == m) {
                return true;
            }
        }

        return false;
    }

    private static boolean improvedNaiveMatch(String text, String patt) {
        int n = text.length();
        int m = patt.length();

        for(int i = 0; i <= n-m;) {
            int j;
            for (j = 0; j<m;j++) {
                if (patt.charAt(j) != text.charAt(i+j)) {
                    break;
                }
            }

            if (j == m) {
                return true;
            }

            if (j == 0)
                i++;
            else
                i += j;
        }

        return false;
    }

}
