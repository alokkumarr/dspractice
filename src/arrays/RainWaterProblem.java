package arrays;


import java.util.Arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 */
public class RainWaterProblem {

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(Arrays.toString(arr));
        System.out.println("--------------------------");
        System.out.println(findWaterAtBestSolution(arr));
    }

    static int findWaterAtBestSolution(int arr[]) {
        int res = 0;
        int n = arr.length;

        // left bar of every element
        int[] lmax = new int[n];
        lmax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(lmax[i-1], arr[i]);
        }

        // right bar of every element
        int[] rmax = new int[n];
        rmax[n-1] = arr[n-1];
        for (int i = n-2; i > 0;i--){
            rmax[i] = Math.max(rmax[i+1], arr[i]);
        }
        //System.out.println(Arrays.toString(rmax));

        // find the min of left bar and right bar and keep the sum of evey pair
        for (int i = 1; i < n-1; i++) {
            res += (Math.min(lmax[i], rmax[i]) - arr[i]);
        }
        return res;
    }


    // O(n^2)
    /**
     * The solution to this approach no water stored left and right of thr building or bar.
     * The loop will start from index 1 to n-2. Calculate the lmax and rmax from the current element
     * then get the minimum and substarct the current element value. Thats is the water stroed at that index,
     * apply same logic in every element
     * */
    static int findWater(int arr[], int n) {
        int result = 0;
        for (int i =1; i < n -1; i++) {
            int lmax = arr[i];
            for (int j = 0; j < i; j++) {
                lmax = Math.max(lmax, arr[j]);
            }
            int rmax = arr[i];
            for (int j = i+1; j < n; j++) {
                rmax = Math.max(rmax, arr[j]);
            }
            // total water stored
            result += Math.min(lmax, rmax)-arr[i];
        }
        return result;
    }
}
