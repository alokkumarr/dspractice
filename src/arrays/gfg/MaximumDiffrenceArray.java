package arrays.gfg;

/**
 * Leader in array means any element in the array right side is less that the current element.
 */
public class MaximumDiffrenceArray {
    public static void main(String[] args) {
        int[] arr = {7,10,4,3,6,5,2};
        int res = bestSolution(arr);
        System.out.println(res);
    }

    private static int bestSolution(int[] arr) {
        int n = arr.length-1;
        int minVal = arr[0];
        int res = arr[1] - arr[0];

        for (int i = 1; i < n; i++) {
            res = Math.max(res, arr[i] - minVal);
            minVal = Math.min(arr[i], minVal);
        }

        return res;
    }
}
