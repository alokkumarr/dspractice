package reccursion;

public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        int fact = factorialTailRec(n, 1);
        System.out.println(fact);
    }

    private static int factorial(int n) {
        if (n == 0 || n ==1)
            return 1;

        return n*factorial(n-1);
    }

    private static int factorialTailRec(int n, int k) {
        if (n == 0 || n ==1)
            return k;

        return factorialTailRec(n-1, n*k);
    }
}
