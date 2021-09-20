package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestStringWithoutRepeat {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int i = 0, j = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length()) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(j));
                j++;
            }
            set.add(c);
            max = Math.max(max, i - j + 1);
            i++;
        }
        return max;
    }

    static int longestSubstring(String str) {
        int ans = 0;
        int i = -1;
        int j = -1;

        Map<Character, Integer> map = new HashMap<>();

        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            // acquire
            while (i < str.length() -1) {
                i++;
                f1 =true;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.get(ch) == 2) {
                    break;
                } else {
                    int len = i -j;
                    if (len > ans) {
                        ans = len;
                    }
                }
            }

            // release
            while (j < i) {
                j++;
                f2 =true;
                char ch = str.charAt(j);
                map.put(ch, map.get(ch) -1);
                if (map.get(ch) == 1) break;
            }

            if (!f1&& !f2) break;
        }
        return ans;
    }
}
