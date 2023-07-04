package hashing.gfg;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {5,8,6,13,3,-1};
        int sum = 22;
        boolean hasPairs = pairs(arr, sum);
        System.out.println(hasPairs);
    }

    private static boolean pairs(int[] arr, int sum) {
        Set<Integer> set = new HashSet<>();
        int preSum = 0;
        for (int a : arr) {
            preSum += a;
            if (set.contains(preSum - sum))
                return true;
            else if (preSum == sum)
                return true;

            set.add(preSum);
        }
        return false;
    }
}
