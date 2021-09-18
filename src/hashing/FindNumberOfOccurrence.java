package hashing;

import java.util.LinkedHashMap;
import java.util.Map;

public class FindNumberOfOccurrence {
    public static void main(String[] args) {
        int[] array = new int[]{10,20,30,20,10,10,3,4,3,1};
        occurrence(array);
    }

    private static void occurrence(int[] array) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for (int element : array) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        System.out.println(map);
    }
}
