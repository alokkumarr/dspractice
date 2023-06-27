package mathmatic;

import java.util.Arrays;

public class PrimeFactor {
    public static void main(String[] args) {
        isPrimeFactor(121);
    }

    private static void isPrimeFactor(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime1(i)) {
                int x = i;
                while (n % x == 0) {
                    System.out.println(i);
                    x = x*i;
                }
            }
        }
    }

    private static boolean isPrime1(int num) {
        if (num == 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        int i;
        for (i = 5; i*i <= num; i= i + 6) {
            return num % i != 0 && num % (i + 2) != 0;
        }
        return false;
    }
}
