package queue;

import java.util.Stack;

public class ImplementQueueWithStack {

    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    void enQueue(int data) {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }

        st1.push(data);

        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
    }

    int dequeue() {
        while (st1.isEmpty()) {
            System.out.println("Empty queue");
            return -1;
        }
        return st1.pop();
    }
}
