package string;

import java.util.Arrays;

public class ReverseWord {
    public static void main(String[] args) {
        String str = "geeks for geekers";
        reverseWord(str.toCharArray());
        //System.out.println(str);
    }


    static void reverseWord(char[] str) {
        int start = 0;
        for (int i=0; i<str.length;i++){
            if (str[i] == ' ') {
                reverse(str, start, i-1);
                start = i+1;
            }
        }

        // reverse the last word
        reverse(str, start, str.length-1);

        // reverse the complete string
        reverse(str, 0, str.length-1);
    }

    static void reverse(char[] str, int low, int high) {
        while (low < high) {
            char ch = str[low];
            str[low] = str[high];
            str[high] = ch;
            low++;
            high--;
        }
        System.out.println(String.valueOf(str));
    }
}
