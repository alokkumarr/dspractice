package arrays.gfg;

import java.util.Arrays;

public class FindMaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] arr = {1,0,1,1,1,0,1,1,1,1};
        int result = findMaxConsecutive(arr);
        System.out.println("Result : " + result);
    }

    private static int findMaxConsecutive(int[] nums) {
        int cur = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cur = 0;
            } else {
                cur++;
                res = Math.max(res, cur);
            }
        }
        return res;
    }
}
