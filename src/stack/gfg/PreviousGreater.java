package stack.gfg;

import java.util.Stack;

public class PreviousGreater {
    /**
     * We are given an array of distinct integers, and our task is to find the closest (positive wise)
     * greater element on left of every element. If there is no greater element on left, then we print -1.
     * We will explore both the Naive and the Efficient Approach (using Stack) to solve the problem.
     */
    public static void main(String[] args) {
        int[] arr = {20, 30, 10, 5, 15};//{60, 10, 20, 15, 35, 50};
        // o/p = >   -1  60  60 20 60 60
        //  -1 20 30 10 30
        solutionPrevGreater(arr);

        // next greater problem
        solutionGreater(arr);

    }

    public static int[] solutionGreater(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        st.push(arr[n-1]);
        int[] op = new int[arr.length];
        op[n-1] = -1;

        for (int i = n-2; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }

            int res = st.isEmpty() ? -1 : st.peek();
            op[i] = res;
            st.push(arr[i]);
        }


        for (int i = 0; i < n; i++) {
            System.out.print(op[i] + " ");
        }
        return op;
    }

    public static int[] solutionPrevGreater(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);

        int[] op = new int[arr.length];
        op[0] = -1;

        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }
            int res = st.isEmpty() ? -1 : st.peek();
            op[i] = res;
            System.out.print(res + " ");
            st.push(arr[i]);
        }
        return op;
    }
}
