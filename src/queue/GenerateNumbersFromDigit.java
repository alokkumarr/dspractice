package queue;

import java.util.Set;
import java.util.TreeSet;
import java.util.Queue;
import java.util.LinkedList;


public class GenerateNumbersFromDigit {
    public static void main(String[] args) {
        Set<String> queue = generateAllNumbers(new int[]{5,6}, 10);
        System.out.println(queue);
    }

    static Set<String> generateAllNumbers(int[] arr, int n) {
        Set<String> set = new TreeSet<>();
        String num1 = String.valueOf(arr[0]);
        String num2 = String.valueOf(arr[1]);
        Queue<String> queue = new LinkedList<>();
        queue.add(num1);
        queue.add(num2);
        for (int i = 0; i < n; i++) {
            String tmp = queue.poll();
            set.add(tmp);
            queue.add(tmp+num1);
            queue.add(tmp+num2);
        }
        return set;
    }
}
