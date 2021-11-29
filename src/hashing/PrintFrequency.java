package hashing;

import java.util.HashMap;
import java.util.Map;

public class PrintFrequency {
    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 30, 10};
        printFrequencyByMap(arr);
    }

    private static void printFrequencyByMap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

        private static void printFrequence(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (flag) continue;

            int count = 0;
            int element = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (element == arr[j]) count++;
            }
            System.out.println(element + " -> " + count);
        }
    }
}
