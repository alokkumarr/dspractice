package stack;

import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] stock = {60, 10, 20, 40, 35, 30, 50, 70, 65};
        printStockSpan(stock);
    }

    private static void printStockSpan(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // index of element to be pushed into stack
        System.out.print(1 + " -> ");
        for (int i = 1; i < arr.length; i++){
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            int span = stack.isEmpty() ? i+1 : i-stack.peek();
            System.out.print(span + " -> ");
            stack.push(i);
        }
    }
}
