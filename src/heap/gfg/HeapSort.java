package heap.gfg;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {10, 15, 4, 50, 20, 45};

        int n = arr.length;
        HeapSort sort = new HeapSort();
        sort.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public void buildHeap(int[] arr,int n){
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
    }

    public void sort(int[] arr) {

        int n = arr.length;
        buildHeap(arr,n);

        for (int i=n-1; i>0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    void heapify(int[] arr, int n, int i) {
        int l = (2*i + 1)/2;
        int r = (2*i + 2)/2;

        int largest = i;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
