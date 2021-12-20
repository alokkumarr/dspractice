package string;

public class LongestCommonPalindrome {


    public String longestPalindrome(String s) {
        int strLength = s.length();
         if (strLength < 2) {
             return s;
         }

         int start = 0;
         int end = 0;
         for (int i = 0; i < strLength-1; i++) {
             // check the palindrome from middle for every substring
             // it will call two time one for even and odd
             int len1 = expandRange(s, i, i);
             int len2 = expandRange(s, i, i+1);
             int len = Math.max(len1, len2);
             if (len > end-start) {
                 start = i - ((len-1)/2);
                 end = i + (len/2);
             }
         }
         return s.substring(start, end+1);
    }

    private int expandRange(String str, int begin, int end) {
        while (begin >= 0 && end < str.length()
                && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        // check if the previous result is greater
        return end-begin-1;
    }
}
