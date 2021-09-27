package arrays;

import java.util.Arrays;

public class RotateAnArrayByK {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7}; int k = 3;
        int[] result = rotateKTimesArray(arr,k);
        System.out.println(Arrays.toString(result));
    }

    private static int[] rotateKTimesArray(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        reverse(nums, 0, len-1);
        System.out.println(Arrays.toString(nums));
        reverse(nums, 0, k-1);
        System.out.println(Arrays.toString(nums));
        reverse(nums, k, len-1);
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    private static  void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
