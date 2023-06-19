package reccursion;

public class PalinromeString {
    public static void main(String[] args) {
        String str = "abac";
        boolean isPalindrome = checkPalindrome(str);
        System.out.println(isPalindrome);
    }

    private static boolean checkPalindrome(String str) {
        int n = str.length();
        return havePalindrome(str, 0, n-1);
    }

    private static boolean havePalindrome(String str, int start, int end) {
        if (start >= end)
            return true;

        return (str.charAt(start) == str.charAt(end))
                && havePalindrome(str, start + 1, end - 1);
    }

}
