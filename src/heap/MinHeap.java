package heap;

import java.util.Arrays;

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

    void minHeapify(int i) {
        int lf = left(i);
        int rt = right(i);

        int smallest = i;
        if (lf < size && arr[lf] < arr[i]) {
            smallest = lf;
        }
        if (rt < size && arr[rt] < arr[smallest]) {
            smallest = rt;
        }

        if (smallest != i) {
            swap(arr, smallest, i);
            minHeapify(smallest);
        }
    }


    int extractMin() {
        if (size == 0)
            return Integer.MAX_VALUE;

        if (size == 1){
            size --;
            return arr[0];
        }

        // replace last element with parent ie 0th index
        swap(arr, 0, size-1);
        size--;
        minHeapify(0);
        int data = arr[size];
        arr[size] = 0;
        return data;
    }

    void decreaseKey(int i, int x) {
        arr[i] = x;
        while (i != 0 && arr[parent(i)] > arr[i]) {
            swap(arr, parent(i), i);
            i = parent(i);
        }
    }


    void buildHeap() {
        for (int i = (size - 2/2); i >= 0; i--){
            minHeapify(i);
        }
    }

    void deleteHeapKey(int x) {
        arr[x] = Integer.MIN_VALUE;
        decreaseKey(3, Integer.MIN_VALUE);
        extractMin();
    }

    public static void main(String[] args) {
        //int[] arr = {10, 20, 15, 40, 50, 100, 25, 45};
        MinHeap heap = new MinHeap(10);
        heap.insert(25);
        heap.insert(100);
        heap.insert(10);
        heap.insert(15);
        heap.insert(20);

        heap.insert(30);
        heap.insert(40);
        heap.insert(50);

        System.out.println(Arrays.toString(heap.arr));
        heap.buildHeap();
        System.out.println(heap.extractMin());
        System.out.println(Arrays.toString(heap.arr));

        heap.decreaseKey(3, 8);
        System.out.println(Arrays.toString(heap.arr));

        heap.deleteHeapKey(2);
        System.out.println(Arrays.toString(heap.arr));

    }
}
