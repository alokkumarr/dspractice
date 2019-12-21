package sort;

import java.util.Arrays;

public class SeelctionSort {
	public static void main(String[] args) {
		int[] arr = {19,10,30,87,-2,23,54,28};
		int len = arr.length;
		System.out.println(Arrays.toString(arr));
		selectionSort(arr, len);

		System.out.println(Arrays.toString(arr));

	}

	/**
	 * first find the minimum element then sawp the min element to first pos
	 * apply this for all elements
	 * @param arr
	 * @param len
	 */
	private static void selectionSort(int[] arr, int len) {
		for (int i = 0; i<len-1;i++){
			int min_indx = i;
			for (int j =i+1;j<len; j++){
				if (arr[j] < arr[min_indx]){
					min_indx = j;
				}
			}

			//swap the element
			int temp = arr[min_indx];
			arr[min_indx] = arr[i];
			arr[i]=temp;
		}
	}

	static int min(int arr[], int k, int n) {
		int loc, min;
		min = arr[k];
		loc = k;
		for (int j = k + 1; j < n - 1; j++) {
			if (min > arr[j]) {
				min = arr[j];
				loc = j;
			}
		}
		return loc;
	}
}
