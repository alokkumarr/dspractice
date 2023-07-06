package string.gfg;

public class PalindromeString {

    public static void main(String[] args) {
        String str = "AABA";
        boolean res = isPalindrome(str);
        System.out.println(res);
    }

    private static boolean isPalindrome(String str) {
        int s = 0, e = str.length()-1;

        while (s < e) {
            if (str.charAt(s) != str.charAt(e))
                return false;

            s++;
            e--;
        }
        return true;
    }


}
