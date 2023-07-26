package binarysearchtree.gfg;

import java.util.Set;
import java.util.TreeSet;

public class LeftSideCeilingInArray {
    public static void main(String[] args) {
        int[] arr = {2, 8, 30, 15, 25, 12};
        //Op = -1, -1, -1, 30, 30, 15

        leftSideCeilingNaive(arr);
        System.out.println();
        leftSideCeilingBest(arr);


    }

    private static void leftSideCeilingBest(int[] arr) {
        System.out.print(-1 + " ");
        TreeSet<Integer> set = new TreeSet<>();
        set.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(set.ceiling(arr[i])!=null)
                System.out.print(set.ceiling(arr[i])+" ");
            else
                System.out.print(-1+" ");

            set.add(arr[i]);
        }
    }


    // O(n^2)
    private static void leftSideCeilingNaive(int[] arr) {
        System.out.print(-1 + " ");
        for (int i = 1; i < arr.length; i++) {
            int diff = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (arr[j] >= arr[i]) {
                    diff = Math.min(diff, arr[j]-arr[i]);
                }
            }
            if (diff == Integer.MAX_VALUE)
                System.out.print(-1 + " ");
            else
                System.out.print(arr[i] + diff + " ");
        }
    }
}
