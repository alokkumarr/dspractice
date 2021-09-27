package arrays;

import java.util.Arrays;

public class SquareRootOfArray {
    public static void main(String[] args) {
        int[] arr = {-7,-3,2,3,11};
        int[] res = squareRootArray(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] squareRootArray(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = nums.length-1; i >= 0; i--)
            if(Math.abs(nums[left]) > nums[right]) {
                res[i] = nums[left] * nums[left];
                left++;
            } else {
                res[i] = nums[right]*nums[right];
                right --;
            }
        return res;
    }
}
