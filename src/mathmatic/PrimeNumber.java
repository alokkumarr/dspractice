package mathmatic;

public class PrimeNumber {
    public static void main(String[] args) {
        boolean isPrime = isPrime1(121);
        System.out.println("Numer is prime : " + isPrime);
    }

    private static boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i < num; i++) {
            if(num % i == 0)
                return false;
            return true;
        }
        return false;
    }

    private static boolean isPrime1(int num) {
        if (num == 1) return false;

        if (num == 2 || num == 3) return true;

        if (num % 2 == 0 || num % 3 == 0) return false;

        for (int i = 5; i*i <= num; i= i + 6) {
            if(num % i == 0 || num % (i+2) == 0)
                return false;
            return true;
        }
        return false;
    }
}
