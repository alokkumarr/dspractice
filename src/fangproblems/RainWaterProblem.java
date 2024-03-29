package fangproblems;


/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 */
public class RainWaterProblem {

    public static void main(String[] args) {
        int[] arr = {2,3,0,1,2,5};
        System.out.println(findWater(arr, arr.length));
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
