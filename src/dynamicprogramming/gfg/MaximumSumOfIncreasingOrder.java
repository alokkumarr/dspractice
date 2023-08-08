package dynamicprogramming.gfg;

public class MaximumSumOfIncreasingOrder {
    public static void main(String[] args) {
        int[] arr = {10,20,9,33,21,50,41,60,80};

        //op - 10,20,21,41,60,80

        int res = maximumSumIncreasing(arr, arr.length);
        System.out.println(res);
    }

    private static int maximumSumIncreasing(int[] arr, int n) {
        int[] misum = new int[n];

        for (int i = 0; i < n; i++) {
            misum[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    misum[i] = Math.max(misum[i], arr[i] + misum[j]);
                }
            }
        }

        // find the max in the array is the result
        int res = misum[0];
        for (int i = 0; i < n; i++) {
            res = Math.max(res, misum[i]);
        }
        return res;
    }
}
