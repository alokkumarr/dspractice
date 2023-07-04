package hashing.gfg;

import java.util.HashSet;
import java.util.Set;

public class FindPairElement {
    public static void main(String[] args) {
        int[] arr = {3,2,8,15,-8};
        int k = 17;
        boolean havePairs = findPairs(arr, k);
        System.out.println(havePairs);
    }

    private static boolean findPairs(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for (int a : arr) {
            if (set.contains(k-a))
                return true;
            else
                set.add(a);
        }
        return false;
    }
}
