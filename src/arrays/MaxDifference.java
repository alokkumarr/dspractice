package arrays;

public class MaxDifference {
    public static void main(String[] args) {
        int[] arr = {2,3,10,6,4,50,8,1};
        int result = maxDifference(arr);
        System.out.println("Result : " + result);
    }

    private static int maxDifference(int[] arr) {
        int minVal = arr[0];
        int res = arr[1] - arr[0];
        for (int j = 1; j < arr.length; j++) {
            res = Math.max(res, arr[j] - minVal);
            minVal = Math.min(arr[j], minVal);
        }
        return res;
    }
}
