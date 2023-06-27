package reccursion;

public class JosephProblem {



    public static void main(String[] args) {
        int survivor = jpshephProb(5, 3);
        System.out.println("Survivor : " + survivor);
    }

    private static int jpshephProb(int n, int k) {
        if (n == 1)
            return 0;

        return (jpshephProb(n - 1, k) + k) % n;
    }

}