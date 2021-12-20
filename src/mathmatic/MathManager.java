package mathmatic;

public class MathManager {
    public static void main(String[] args) {
        int x = 3883;
        System.out.println(isPalindrome(x));
    }

    static boolean isPalindrome(int num) {
        int rev = 0;
        int x = num;
        while (x > 0) {
            int rem = x % 10;;
            rev = rev * 10 + rem;
            x = x /10;
        }
        return  num == rev;
    }

    static int countDigit(int x) {
        int count = 0;
        while (x > 0) {
            x = x / 10;
            count++;
        }
        return count;
    }
}
