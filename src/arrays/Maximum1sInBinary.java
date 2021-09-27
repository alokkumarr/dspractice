package arrays;

import java.util.HashMap;
import java.util.Map;

public class Maximum1sInBinary {

    public static void main(String[] args) {
        int[] arr = {0,1,1,1,0,0,1,1,1,1,0,1,0};
        int result = max1stConsecutiveInBinary(arr);
        System.out.println("Result : " + result);
    }

    private static int max1stConsecutiveInBinary(int[] nums) {
        int res = 0;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                curr = 0;
            } else {
                curr++;
                res = Math.max(res, curr);
            }
        }
        return res;
    }
}
