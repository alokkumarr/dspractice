package arrays;

public class WindowSlidingProblem {
    public static void main(String[] args) {
        int[] arr = {1,8,30,-5,20,7};
        int k = 3;
        maxSum(arr, k);

        arr = new int[]{1, 4, 20, 3, 10, 5};
        k = 33;
        System.out.println(windowSlidingForNonNegative(arr, k));

    }

    private static void maxSum(int[] arr, int k) {
        int curSum = 0;
        for (int i = 0; i < k; i++) {
            curSum += arr[i];
        }

        int maxSum = curSum;
        for (int i = k; i < arr.length; i++) {
            curSum = curSum + (arr[i] - arr[i-k]);
            maxSum = Math.max(curSum, maxSum);
        }
        System.out.println("Max Sum : " + maxSum);
    }


    /*
     This technique only work for non-Negative number
     O(n)
     */
    private static boolean windowSlidingForNonNegative(int[] arr, int target) {
        int start = 0, currSum = arr[0];
        for (int end = 1; end < arr.length; end ++) {
            while (currSum > target && start < end-1) {
                currSum -= arr[start];
                start++;
            }
            if (currSum == target) return true;
            currSum += arr[end];
        }
        return (currSum == target);
    }

}
