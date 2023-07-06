package hashing.gfg;

import java.util.*;

public class CountDistinctElementWindow {

    public static void main(String[] args) {
        int[] arr = {10,10,5,3,20,5};
        int k = 4;
        solutionBest(arr, k);
        //System.out.println(res);
    }

    private static void solutionBest(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(map);

        // print first frequency
        System.out.print(map.size());


        for (int i = k; i < arr.length; i++) {
            // add next element
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            // check if any repeated element remove the frequency
            int element  = arr[i-k];
            map.put(element, map.get(element)-1);

            // if zero frequency then remove
            if (map.get(element) == 0) {
                map.remove(element);
            }

            // print size
            System.out.print(" " + map.size());
        }
    }
}
