package hashing.gfg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        int[] arr = {1,9,3,4,2,20};
        int res = solution(arr);
        System.out.println(res);
    }

    private static int solution(int[] arr) {
        System.out.println(Arrays.toString(arr));

        // first add all element in hash
        Set<Integer> hs = new HashSet<>();
        for (int a : arr) {
            hs.add(a);
        }

        // look for every element less than 1
        int res = 0;
        for (int x : arr) {
            if (!hs.contains(x - 1)) {
                int curr = 1;
                while (hs.contains(x + curr)) {
                    curr++;
                }
                res = Math.max(res, curr);
            }
        }
        return res;
    }

    // O(nlogn)
    private static int naiveSolution(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int curr = 1, res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1] + 1) {
                curr++;
            } else if (arr[i] != arr[i-1]){
                res = Math.max(res, curr);
                curr = 1;
            }
        }
        res = Math.max(res, curr);
        return res;
    }
}
