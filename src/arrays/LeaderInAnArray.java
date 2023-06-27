package arrays;

import java.util.Arrays;

/**
 * Leader in array means any element in the array right side is less that the current element.
 */
public class LeaderInAnArray {
    public static void main(String[] args) {
        int[] arr = {7,10,4,3,6,5,2};

        int res1 = naiveSolution(arr);
        System.out.println(res1);

        int res = bestSolution(arr);
        System.out.println("Best Solution : " + res);
    }

    private static int bestSolution(int[] arr) {
        int res = 1;
        return res;
    }

    private static int naiveSolution(int[] arr) {
        return 0;
    }
}
