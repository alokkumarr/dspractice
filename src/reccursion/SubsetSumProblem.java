package reccursion;

public class SubsetSumProblem {

    public static void main(String[] args) {
        int count = sumSubsetCount(new int[]{5, 20, 15, 10}, 4, 25);
        System.out.println(count);
    }

    private static int sumSubsetCount(int[] arr, int n, int sum) {
        if (n == 0)
            return sum == 0 ? 1 : 0;

        return sumSubsetCount(arr, n - 1, sum)
                + sumSubsetCount(arr, n - 1, sum - arr[n-1]);
    }
}