package hashing.gfg;

import java.util.HashSet;
import java.util.Set;

public class InterSectionOfTwoArray {
    public static void main(String[] args) {
        int[] a = {10,20,30};
        int[] b = {20,10};
        intersection(a, b);
    }

    private static void intersection(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        for (int ele : b) {
            set.add(ele);
        }

        for (int ele : a) {
            if (set.contains(ele))
                System.out.print(ele +" ");
        }
    }
}
