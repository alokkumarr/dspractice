package string;

/*
Constructing longest proper prefix and suffix
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str = "ababacab";
        int[] lps = new int[str.length()];
        int index = longestPropSuffixPrefix(str, str.length());
        System.out.println(index);
    }

    private static int longestPropSuffixPrefix(String str, int n) {
        for (int len = n-1; len > 0; len--){
            boolean flag = true;
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) != str.charAt(n-len+i)){
                    flag = false;
                }
            }
            if (flag) return len;
        }
        return 0;
    }

    static void fillLPS(String str, int lps[]) {
        for (int i = 0; i < str.length(); i++) {
            lps[i] = longestPropSuffixPrefix(str, i + 1);
        }
    }
}
