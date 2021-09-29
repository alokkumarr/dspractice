package heap;

public class MinHeap {
    int[] arr;
    int capacity;
    int size;

    MinHeap(int c) {
        arr = new int[c];
        size = 0;
        capacity = c;
    }


    void insert(int x) {
        if (capacity == size) return;
        size++;
        arr[size-1] = x;
        for (int i = size-1; i != 0 && arr[parent(i)] > arr[i];) {
            swap(arr, parent(i), i);
            i = parent(i);
        }
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    int parent(int i) {
        return (i - 1)/2;
    }

    int capacity() {
        return capacity;
    }

    int size() {
        return size;
    }

    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
