package queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackWithQueue {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // need extra queue to add item in front
    public void push(int x) {
        while (!q1.isEmpty())
            q2.add(q1.poll());

        q1.add(x);

        while (!q2.isEmpty())
            q1.add(q2.poll());
    }

    public int pop() {
        return q1.poll();
    }

    int top() {
        return q1.peek();
    }

    int size() {
        return q1.size();
    }
}
