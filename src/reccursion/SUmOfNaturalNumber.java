package reccursion;

public class SUmOfNaturalNumber {
    public static void main(String[] args) {
        int n = 3;
        int fact = sumOfNatural(n);
        System.out.println(fact);
    }

    private static int sumOfNatural(int n) {
       if (n == 0) return 0;

        return n + sumOfNatural(n-1);
    }
}
