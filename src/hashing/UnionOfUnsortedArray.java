package hashing;

import java.util.HashSet;
import java.util.Set;

public class UnionOfUnsortedArray {
    public static void main(String[] args) {
        int[] arr1 = {10,20,10,20,30,4,5};
        int[] arr2 = {5,30,8,40,11,19};
        int result = getUionByNaive(arr1, arr2, arr1.length, arr2.length);
        System.out.println("Naive solution : " + result);
        int resultBest = getUnionByHash(arr1, arr2);
        System.out.println("Best Solution : " + resultBest);

    }

    private static int getUnionByHash(int[] arr1, int[] arr2) {
        final Set<Integer> set = new HashSet<>();
        for (int i : arr1) set.add(i);
        for (int i : arr2) set.add(i);
        return set.size();
    }

    private static int getUionByNaive(int[] arr1, int[] arr2, int length, int length1) {
        return 0;
    }
}
