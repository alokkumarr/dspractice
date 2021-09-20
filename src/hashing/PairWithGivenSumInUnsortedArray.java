package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairWithGivenSumInUnsortedArray {
    public static void main(String[] args) {
        int[] arr = {3,9,4,20,19,1};
        int k = 20;
        boolean hasPair = checkValidPairNaive(arr, k);
        System.out.println("Pair exist in array by naive :" + hasPair);
        hasPair = checkValidPair(arr, k);
        System.out.println("Pair exist in array by best :" + hasPair);
    }

    private static boolean checkValidPair(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(k-arr[i])) {

                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }

    private static boolean checkValidPairNaive(int[] arr, int sum) {

        for (int i = 0; i< arr.length; i++) {
            for (int j = 1; j < arr.length; j++){
                if (arr[i] + arr[j] == sum) {
                    return true;
                }
            }
        }


        return false;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
