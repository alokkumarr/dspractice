package heap.gfg;

import java.util.Arrays;

public class BinaryHeapImplementation {

    public static void main(String[] args) {
        BinaryHeapImplementation bhi = new BinaryHeapImplementation(10);
        bhi.insert(10);
        bhi.insert(20);
        bhi.insert(8);
        bhi.insert(9);
        bhi.insert(11);
        bhi.insert(22);
        bhi.insert(89);
        bhi.insert(4);

        //bhi.print();
        // get min element
        //System.out.println(bhi.extractMin());
        //bhi.print();
        bhi.insert(92);
        //bhi.print();
        bhi.insert(88);
        bhi.print();

        bhi.decreaseKey(7, 2);
        bhi.print();
    }

    void decreaseKey(int i, int x) {
        arr[i] = x;
        while (i != 0 && arr[parent(i)] > arr[i]) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    int extractMin() {
        if (size == 0)
            return Integer.MIN_VALUE;

        if (size == 1) {
            size --;
            return arr[0];
        }

        // swap 1st and last elements
        swap(0, size-1);

        size --;

        minHeapify(0);
        return arr[size];
    }

    void minHeapify(int i) {
        int lt = left(i);
        int rt = right(i);

        int smallest = i;
        if (lt < size && arr[lt] < arr[smallest]) {
            smallest = lt;
        }

        if (rt < size && arr[rt] < arr[smallest]) {
            smallest = rt;
        }

        if (smallest !=  i) {
            // swap the element with the smallest
            swap(smallest, i);

            minHeapify(smallest);
        }
    }

    void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }



    int cap;
    int[] arr;
    int size;

    BinaryHeapImplementation(int cap) {
        this.cap = cap;
        size = 0;
        arr = new int[cap];
    }

    void insert(int x) {
        if (size == cap)
            return;

        size++;
        arr[size-1] = x;

        for (int i = size -1; i != 0 && arr[parent(i)] > arr[i];) {
            swap(parent(i), i);

            i = parent(i);
        }
    }


    /** (2i + 1) / 2 **/
    int left(int i) {
        return (2*i + 1)/2;
    }

    /** (2i + 2) / 2 **/
    int right(int i) {
       return  (2*i + 2)/2;
    }

    /** floor (i - 1) / 2 **/
    int parent(int i) {
        return (int) Math.floor((i-1)/2);
    }

    void print() {
        System.out.println(Arrays.toString(arr));
    }
}
