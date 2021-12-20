package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGreaterProblem {
    public static void main(String[] args) {
        int[] stock = {60, 10, 20, 40, 35, 30, 50, 70, 65};
        printStockSpan(stock);
    }

    private static void printStockSpan(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[arr.length-1 ]); // index of element to be pushed into stack
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        for (int i = arr.length-2; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            int span = stack.isEmpty() ? -1 : stack.peek();
            list.add(span);
            stack.push(arr[i]);
        }
        Collections.reverse(list);
        System.out.println(list);
    }
}
