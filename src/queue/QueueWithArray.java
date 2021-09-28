package queue;

public class QueueWithArray {
    int size, capacity;
    int[] arr;

    QueueWithArray(int c) {
        capacity = c;
        size = 0;
        arr = new int[capacity];
    }

    public void enqueue(int x) {
        if (isFull()) return;
        arr[size] = x;
        size++;
    }

    public void dequeue() {
        if (size == 0) return;
        for (int i = 0; i < arr.length; i++) arr[i] = arr[i+1];
        size--;
    }

    public int getFront(int x) {
        if (isEmpty()) return -1;
        return arr[0];
    }

    public int getRear(int x) {
        if (size == 0) return -1;
        return arr[size-1];
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
