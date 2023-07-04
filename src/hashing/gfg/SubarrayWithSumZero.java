package hashing.gfg;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWithSumZero {
    public static void main(String[] args) {
        int[] arr = {-3,4,-3,-1,7};
        boolean hasPairs = pairs(arr);
        System.out.println(hasPairs);
    }

    private static boolean pairs(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int preSum = 0;
        for (int a : arr) {
            preSum += a;
            if (set.contains(preSum))
                return true;
            else if (preSum == 0)
                return true;

            set.add(preSum);
        }
        return false;
    }
}
