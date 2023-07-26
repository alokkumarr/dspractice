package heap.gfg;

import java.util.Arrays;

public class BuildHeap {
    public static void main(String[] args) {
        int[] arr = {10, 4, 9, 21, 23, 56, 40, 29};
        /*
         *                   10
         *                /     \
         *               4      9
         *             /  \    / \
         *            21   23 56  40
         *           /
         *          29
         */

        BuildHeap bh = new BuildHeap(arr.length, arr);
        bh.buildHeap();
        System.out.println(Arrays.toString(bh.arr));
    }

    int[] arr;
    int size;
    int capacity;

    BuildHeap(int capacity, int[] arr) {
        this.capacity = capacity;
        this.arr = arr;
        size = arr.length;
    }

    int left(int i) {
        return (2*i+1) / 2;
    }

    int right(int i) {
        return (2*i+2) / 2;
    }

    int parent(int i) {
        return (int) Math.floor((i-1)/2);
    }

    void minHeapify(int i) {
        int lt = left(i);
        int rt = right(i);

        int smallest = i;
        if (lt < size && arr[smallest] > arr[lt]) {
            smallest = lt;
        }
        if (rt < size && arr[smallest] > arr[rt]) {
            smallest = rt;
        }

        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    void swap(int a, int b) {
        int tmp = arr[a];
        arr[b] = arr[a];
        arr[a] = tmp;
    }

    private void buildHeap() {
        for (int i = (size - 2)/2; i >= 0; i--) {
            minHeapify(i);
        }
    }
}
