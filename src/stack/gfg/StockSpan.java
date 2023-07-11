package stack.gfg;

import java.util.Stack;

public class StockSpan {
    /**
     * We have a series of N daily price quotes for a stock and we need to calculate
     * the span of the stock's price for all N days. The span Si of the stock's price
     * on a given day i is defined as the maximum number of consecutive days just before
     * the given day, for which the price of the stock on the current day is less than
     * its price on the given day.
     */
    public static void main(String[] args) {
        int[] arr = {60, 10, 20, 15, 35, 50};
        findStockSpan(arr);

    }

    private static void findStockSpan(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        System.out.print(1 + " ");

        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            int span = st.isEmpty() ? i+1 : i - st.peek();
            System.out.print(span + " ");
            st.push(i);
        }
    }
}
