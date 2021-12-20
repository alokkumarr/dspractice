package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0, count = map.size();
        int left = 0, right = s.length() - 1, min = s.length();
        boolean found = false;

        while (j < s.length()) {
            char endChar = s.charAt(j++);
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) -1);
                if (map.get(endChar) == 0) count -= 1;
            }

            if (count > 0) continue;

            while (count == 0) {
                char startChar = s.charAt(i++);
                if (map.containsKey(startChar)){
                    map.put(startChar, map.get(startChar)+1);
                    if (map.get(startChar) > 0) count+=1;
                }
            }

            if ((j-i) < min) {
                left = i;
                right = j;
                min = j - i;
                found = true;
            }
        }
        return !found ? "" : s.substring(left-1, right);
    }


    public String minWindow1(String s, String t) {
        String ans = "";
        // build a target string map with frequency
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }

        int matchCount = 0;
        int desiredMathCount = t.length();
        Map<Character, Integer> cMap = new HashMap<>();
        int i = -1, j =-1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            // acquire the char
            while (i < s.length() - 1 && matchCount < desiredMathCount) {
                i++;
                char ch = s.charAt(i);
                cMap.put(ch, cMap.getOrDefault(ch, 0) + 1);

                if(tmap.getOrDefault(ch, 0) <= cMap.getOrDefault(ch, 0)) {
                    matchCount++;
                }
                f1 = true;
            }

            // collect answer and release
            while (j < i && matchCount == desiredMathCount) {
                String potentialAns = s.substring(j + 1, i + 1);
                if (ans.length() == 0 || potentialAns.length() < ans.length()) {
                    ans = potentialAns;
                }

                j++;
                char ch = s.charAt(j);
                if (cMap.get(ch) == 1) {
                    cMap.remove(ch);
                } else {
                    cMap.put(ch, cMap.get(ch) - 1);
                }

                // check the desired map frequency
                if (cMap.getOrDefault(ch, 0) < tmap.getOrDefault(ch, 0)) {
                    matchCount --;
                }
                f2 = true;
            }

            // break the loop if no loop exeuted
            if (!f1 && !f2)
                break;
        }
        return ans;
    }
}
