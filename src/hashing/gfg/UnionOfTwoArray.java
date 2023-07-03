package hashing.gfg;

import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoArray {
    public static void main(String[] args) {
        int[] a = {10,20,30};
        int[] b = {20,10};
        union(a, b);
    }

    private static void union(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        for (int ele : b) {
            set.add(ele);
        }

        for (int ele : a) {
            set.add(ele);
        }

        System.out.println(set.size());
    }
}
