package reccursion;

public class SumOfDigit {
    public static void main(String[] args) {
        int str = 256;
        int sum = fun(str);
        System.out.println(sum);
    }

    private static int fun(int n) {
       if(n == 0) return 0;

       return n % 10 + fun(n/10);
    }

}
