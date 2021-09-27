package arrays;

public class MaxEvenAndOddArray {
    public static void main(String[] args) {
        int[] arr = {2,3,10,6,4,13,8,1,2};
        int result = maxLengthMaxEvenOddSubArray(arr);
        System.out.println("Result : " + result);
    }

    private static int maxLengthMaxEvenOddSubArray(int[] arr) {
        int res = 1;
        int curr = 1;
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] % 2 == 0 && arr[i-1] % 2 != 0) ||
                    (arr[i] % 2 != 0 && arr[i-1] % 2 == 0)) {
                curr++;
                res = Math.max(res, curr);
            } else {
                curr = 1;
            }
        }
        return res;
    }
}
