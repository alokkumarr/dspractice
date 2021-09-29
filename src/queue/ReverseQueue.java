package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(12);
        queue.add(30);
        queue.add(2);
        queue.add(23);
        System.out.println(queue);

        //queue = reverseQueue(queue);
        reverseQueueRec(queue);
        System.out.println(queue);
    }

    private static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.poll());
                while (!stack.isEmpty())
            queue.add(stack.pop());
               return queue;
    }

    private static void reverseQueueRec(Queue<Integer> queue) {
        if (queue.isEmpty()) return;
        int tmp = queue.poll();
        reverseQueue(queue);
        queue.add(tmp);
    }
}
