package heap;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {10, 15, 50, 4, 20};
        System.out.println(Arrays.toString(arr));
        System.out.println("----------------");
        HeapSort sort = new HeapSort();
        sort.buildHeap(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    void maxHeapify(int[] arr, int n, int i){
        int largest = i;
        int left = (2*i + 1)/ 2;
        int right = (2*i + 2)/ 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(arr, largest, i);
            maxHeapify(arr, n, largest);
        }
    }

    void buildHeap(int[] arr, int n) {
        for (int i = (n-2)/2; i >=0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
