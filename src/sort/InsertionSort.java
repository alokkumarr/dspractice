package sort;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = {19,10,30,87,-2,23,54,28};
		int len = arr.length;
		System.out.println(Arrays.toString(arr));
		insertionSort(arr, len);

		System.out.println(Arrays.toString(arr));
	}

	// O(n^2)
	private static void insertionSort(int[] arr, int n) {
		for (int i=1; i<n; i ++) {
			int key = arr[i];
			int j = i-1;
			while (j>=0 && arr[j] > key){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1]=key;
		}
	}
}
