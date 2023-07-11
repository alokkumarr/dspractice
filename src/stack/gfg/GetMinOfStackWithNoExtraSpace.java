package stack.gfg;

import java.util.Stack;

public class GetMinOfStackWithNoExtraSpace {
    public static void main(String[] args) {
        GetMinOfStackWithNoExtraSpace st = new GetMinOfStackWithNoExtraSpace();
        st.push(10);
        st.push(7);
        st.push(56);
        st.push(1);
        st.push(13);
        st.push(15);

        System.out.println(st.peek());
        System.out.println(st.getMin());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.getMin());
    }

    Stack<Integer> ms;
    int min = 0;

    public GetMinOfStackWithNoExtraSpace() {
        ms = new Stack<>();
    }
    void push(int data) {
        if (ms.isEmpty()) {
            min = data;
            ms.add(data);
        } else if (ms.peek() >= data) {
            //ms.push(data-min);
            // handle negative number as well
            ms.push(2*data - min);
            min = data;
        } else {
            ms.push(data);
        }
    }

    int pop() {
        int t = ms.pop();
        /*if (t < 0) {
            int res = min;
            min = min - t;
            return res;
        }*/
        // handle negative number
        if (t < min) {
            int res = min;
            min = 2*min - t;
            return res;
        } else {
            return t;
        }
    }

    int getMin() {
        return min;
    }

    int peek() {
        int t = ms.peek();
        return t < 0 ? min : t;
    }
}
