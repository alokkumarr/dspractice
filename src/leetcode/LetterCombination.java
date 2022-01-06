package leetcode;

import java.util.*;

public class LetterCombination {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0)
            return ans;

        // build a list of all number words
        Map<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");

        // backtrack function
        backTrack(digits, 0, hm, new StringBuilder(), ans);
        return ans;
    }

    private void backTrack(String digits, int i, Map<Character, String> hm, StringBuilder sb, List<String> ans) {
        // base case to get correct combination
        if (i == digits.length()){
            ans.add(sb.toString());
            return;
        }
        // get the word based upon digit index
        String cur = hm.get(digits.charAt(i));

        // iterate over the curr word
        for (int k = 0; k < cur.length(); k++) {
            sb.append(cur.charAt(k));
            backTrack(digits, i + 1, hm, sb, ans);
            // remove the last char after finding the word
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
