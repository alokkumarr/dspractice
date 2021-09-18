package hashing;

import java.util.HashSet;
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
        for (int data : arr) {
            if (set.contains(k-data)) {
                return true;
            }
            set.add(data);
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
}
