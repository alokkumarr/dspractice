package sort.gfg;

import java.util.Arrays;

public class PartitionOfArray {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 1, 78, 9798, 97 };//{5,3,8,4,2,7,1,10};
        int res = hoarsPartition(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(res);
    }


    private static int naivePartition(int[] arr) {
        int l = 0, h = arr.length - 1;

        int[] tmp = new int[(h - l) + 1];
        int pivot = arr[h];
        int index = 0;

        for (int i = l; i <= h; ++i) {
            if (arr[i] < pivot) {
                tmp[index++] = arr[i];
            }
        }
        //pivot position
        int position = index;

        // placing pivot to original position
        tmp[index++] = pivot;

        for (int i = l; i <= h; ++i) {
            if (arr[i] > pivot) {
                tmp[index++] = arr[i];
            }
        }

        for (int i = l; i <= h; i++) {
            arr[i] = tmp[i-l];
        }

        return position;
    }

    private static int lomutoPartition(int[] arr) {
        int l = 0, h = arr.length - 1;

        int i = l - 1;
        int pivot = arr[h]; // always last element

        for (int j = l; j<=h-1; j++) {
            if (arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, h);
        return i+1;
    }


    private static int hoarsPartition(int[] arr) {
        int l = 0, h = arr.length-1;
        int i = l - 1, j = h+1;
        int pivot = arr[l];

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j)
                return j;
            else {
                swap(arr, i, j);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
