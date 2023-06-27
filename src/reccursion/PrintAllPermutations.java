package reccursion;

import java.util.Arrays;

public class PrintAllPermutations {

    public static void main(String[] args) {
        printPermutation("AB", 0);
    }

    private static void printPermutation(String str, int i) {
        if (i == str.length() - 1) {
            System.out.println(str);
            return;
        }

        for (int j = i; j < str.length(); j++) {
            str = swap(str, i, j);
            printPermutation(str, i + 1);
            str = swap(str, i, j);
        }
    }

    private static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}