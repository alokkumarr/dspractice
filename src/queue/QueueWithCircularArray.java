package queue;

public class QueueWithCircularArray {
    int size, capacity, front;
    int[] arr;

    QueueWithCircularArray(int c) {
        capacity = c;
        size = 0;
        front = 0;
        arr = new int[capacity];
    }

    public void enqueue(int x) {
        if (isFull()) return;
        int rear = getRear();
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
    }

    public void dequeue() {
        if (size == 0) return;
        front = (front + 1) % capacity;
        size--;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return arr[(front+size-1) % capacity];
    }

    boolean isFull() {
        return size == capacity;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }
}
