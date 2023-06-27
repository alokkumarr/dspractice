package arrays.gfg;

import java.util.Arrays;

public class RainWaterStorageProblem {

    public static void main(String[] args) {
        int[] arr = {5,0,6,2,3};
        int result = maxCollectWater(arr);
        System.out.println("Result : " + result);
    }

    private static int maxCollectWater(int[] nums) {
        int[] lmax = new int[nums.length];
        lmax[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            lmax[i] = Math.max(nums[i], lmax[i-1]);

        System.out.println(Arrays.toString(lmax));

        int[] rmax = new int[nums.length];
        rmax[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length - 2; i >= 0 ; i--)
            rmax[i] = Math.max(nums[i], rmax[i+1]);
        System.out.println(Arrays.toString(rmax));

        int maxWater = 0;
        for (int i = 1; i < nums.length -1; i++) {
            maxWater += (Math.min(lmax[i], rmax[i]) - nums[i]);
        }
        return maxWater;
    }
}
