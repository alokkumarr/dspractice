package HackerRank.Array2D;

import java.util.Arrays;

public class LeftRotation {
	public static void main(String[] args) {
		int d = 4;
		int arr[] = {1, 2, 3, 4, 5};
		rotLeft(arr, d);
		//System.out.println(Arrays.toString(rotLeft(arr, d)));
	}

	// Complete the rotLeft function below.
	static int[] rotLeft(int[] a, int d) {
		int arr[] = new int[a.length];
		for (int j = 0; j < a.length; j++) {
			arr[j] = a[j];
		}

		for (int j = 0; j < d; j++) {
			int temp = arr[j];
			for (int i = 0; i < a.length - 1; i++) {
				a[i] = a[i + 1];
			}
			a[a.length - 1] = temp;
			//System.out.println(Arrays.toString(a));
		}
		return a;
	}
}
