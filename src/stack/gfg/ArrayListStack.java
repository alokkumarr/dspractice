package stack.gfg;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStack {

    List<Integer> items;

    public ArrayListStack() {
        items = new ArrayList<>();
    }

    int size() {
        return items.size();
    }

    int pop() {
        if (items.size() - 1 < 0) {
            System.out.println("Stack Underflow!");
            return -1;
        }

        int data = items.get(items.size() - 1);
        items.remove(items.size()-1);
        return data;
    }

    int peek() {
        if (items.size() - 1 < 0) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return items.get(items.size() - 1);
    }

    void push(int data) {
        items.add(data);
    }

    public static void main(String[] args) {
        ArrayListStack st = new ArrayListStack();

        System.out.println(st.pop());
        st.push(20);
        System.out.println(st.size());
        System.out.println(st.pop());
        System.out.println(st.size());
        System.out.println(st.peek());
    }
}
