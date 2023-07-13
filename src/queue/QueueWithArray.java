package queue;

public class QueueWithArray {

    int size;
    int capacity;
    int[] arr;
    int front;

    QueueWithArray(int c) {
        capacity = c;
        size = 0;
        front = 0;
        arr = new int[capacity];
    }

    public void enqueue(int x) {
        if (isFull())  {
            System.out.println("Overflow !");
            return;
        }
        int rear = getRear();
        rear = (rear+1) % capacity;
        arr[rear] = x;
        size++;
    }

    public void dequeue() {
        if (isEmpty()) return;
        front = (front+1) % capacity;
        size--;
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        else
            return front;
    }

    public int getRear() {
        if (size == 0)
            return -1;
        else
            return (front+size-1) % capacity;
    }

    boolean isFull() {
        return size == capacity;
    }

    boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        QueueWithArray queue = new QueueWithArray(6);

        queue.enqueue(10);
        queue.enqueue(13);
        queue.enqueue(16);
        queue.enqueue(20);
        queue.enqueue(14);
        queue.enqueue(19);
        System.out.println(queue.isEmpty());
        queue.enqueue(111);
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.getFront());
    }
}
