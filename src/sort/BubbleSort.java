package sort;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {19,10,30,87,-2,23,54,28};

		int len = arr.length;
		System.out.println(Arrays.toString(arr));

		//bubbleSort(arr, len);
		modifiedBubbleSort(arr, len);
		System.out.println(Arrays.toString(arr));
	}

	// O(n)
	private static void modifiedBubbleSort(int[] arr, int n) {
		for (int i =0; i<n-1; i ++) {
			boolean flag = false;
			for (int j = 0; j<n-1-i; j++){
				if (arr[j] > arr[j+1]) {
					flag = true;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			if (!flag){
				System.out.println("Number of round : " + (i+1));
				return;
			}
		}
	}

	// O(n^2)
	private static void bubbleSort(int[] arr, int n) {
		for (int i =0; i<n-1; i ++) {
			for (int j = 0; j<n-1-i; j++){
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
