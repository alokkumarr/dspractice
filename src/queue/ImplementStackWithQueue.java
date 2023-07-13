package queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackWithQueue {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // need extra queue to add item in front
    // q1 is the main queue and q2 is an auxilary one
    public void push(int x) {
        // move all item from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }

        // add item in q1
        q1.add(x);

        // now move all item to q1
        while (!q2.isEmpty())
            q1.add(q2.poll());
    }

    public int pop() {
        return q1.isEmpty() ? -1 : q1.poll();
    }

    int top() {
        return q1.isEmpty() ? -1 : q1.peek();
    }

    int size() {
        return q1.size();
    }

    public static void main(String[] args) {
        ImplementStackWithQueue queue = new ImplementStackWithQueue();
        System.out.println(queue.pop());
        queue.push(10);
        queue.push(15);
        queue.push(16);
        queue.push(20);
        queue.push(22);
        System.out.println(queue.size());
        System.out.println(queue.pop());
        System.out.println(queue.size());
        System.out.println(queue.top());
    }
}
