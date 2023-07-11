package stack.gfg;

import java.util.Stack;

public class GetMinOfStack {
    public static void main(String[] args) {

        Stack<Integer> ms = new Stack<>();
        Stack<Integer> as = new Stack<>();

    }

    Stack<Integer> ms = new Stack<>();
    Stack<Integer> as = new Stack<>();

    void push(int data) {
        if (ms.isEmpty()) {
            ms.push(data);
            as.push(data);
        } else {
            ms.push(data);
            if (ms.peek() <= as.peek())
                as.push(data);
        }
    }

    int pop() {
        if (ms.peek().equals(as.peek()))
            as.pop();

        return ms.pop();
    }

    int getMin() {
        return as.peek();
    }
}
