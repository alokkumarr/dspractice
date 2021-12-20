package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LargestAreaOfHistogram {
    public static void main(String[] args) {
        int[] stock = {6,2,5,4,1,5,6};
        int maxArea = largestAreaOfHistogram(stock);
        System.out.println("Max Area : " + maxArea);
    }


    private static int largestAreaOfHistogramEfficient(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int cur = 0;
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                int tp = st.pop();
                cur = tp * (st.isEmpty() ? i : i - st.peek()-1);
                res = Math.max(cur, res);
            }
            st.push(i);
        }

        return res;
    }

    // O(n^2)
    private static int largestAreaOfHistogram(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            for (int j = i-1; j >= 0; j--) {
                if (arr[j] >= arr[i]) {
                    cur += arr[i];
                } else break;
            }

            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] >= arr[i]) {
                    cur += arr[i];
                } else break;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}
