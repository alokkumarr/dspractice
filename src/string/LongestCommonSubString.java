package string;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubString {

    public static void main(String[] args) {
        String str = "abcabcdbcab";
        System.out.println(longestCommonSubString(str));
    }

    private static int longestCommonSubString(String str) {
        if (str == null || str.length() == 0) return 0;
        int max = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            while (set.contains(ch)) {
                set.remove(ch);
                j++;
            }
            set.add(ch);
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}
