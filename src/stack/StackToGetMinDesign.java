package stack;

import java.util.Stack;

public class StackToGetMinDesign {

    public static void main(String[] args) {
        StackToGetMinDesign st = new StackToGetMinDesign();
        st.push(5);
        st.push(10);
        st.push(20);
        System.out.println(st.getMin());

        st.push(2);
        st.push(6);
        st.push(4);
        System.out.println(st.getMin());

        st.push(21);
        st.pop();
        st.pop();
        st.push(2);
        System.out.println(st.getMin());

        st.pop();
        System.out.println(st.getMin());
        st.push(1);

        System.out.println(st.getMin());
    }

    private Stack<Integer> st = new Stack<>();
    int min;

    public int getMin() {
        return min;
    }

    public void push(int x) {
        if (st.isEmpty()){
            min = x;
            st.push(x);
        } else if (x <= min) {
            st.push(x - min);
            min = x;
        } else {
            st.push(x);
        }
    }

    public int peek() {
        int t = st.peek();
        return (t <= 0) ? min : t;
    }

    public int pop() {
        int t = st.pop();
        if (t <= 0) {
            int res = min;
            min = min-t;
            return res;
        } else {
            return t;
        }
    }
}
