package binarysearchtree;

import java.util.TreeSet;

public class CeilingArrayInSelfBBST {

    public static void main(String[] args) {
        int[] arr = {2, 8, 30, 15, 25, 12};
        int n = 12;
        printCeiling(arr);
    }

    // O(nlogn)
    private static void printCeiling(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(arr[0]);
        System.out.print(" -1 ");
        for (int i = 1; i < arr.length; i++) {
            if (set.ceiling(arr[i]) != null) {
                System.out.print(set.ceiling(arr[i])+ " ");
            } else {
                System.out.print(" -1 ");
            }
            set.add(arr[i]);
        }
    }
}
