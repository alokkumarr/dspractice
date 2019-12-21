package HackerRank.Array2D;

public class MinimumSwaps2 {
	public static void main(String[] args) {
		int arr[] = {7, 1, 3, 2, 4, 5, 6};

		System.out.println(minimumSwaps(arr));
	}

	// Complete the minimumSwaps function below.
	static int minimumSwaps(int[] arr) {
		int first = 0, last = arr.length - 1;
		int swaps = 0;
		while (first < last) {
			while (arr[first] == first + 1 && first < last)
				first++;
			if (first < last) {
				int temp = arr[arr[first] - 1];
				arr[arr[first] - 1] = arr[first];
				arr[first] = temp;
				swaps++;
			}
		}
		return swaps;
	}

		// Complete the minimumSwaps function below.
	static int minimumSwaps1(int[] arr) {
		int swap = 0;

		boolean visited[] = new boolean[arr.length];
		for (int i = 0; i < arr.length; i++) {

			int j = i, count = 0;

			while (!visited[j]) {
				visited[j] = true;
				j = arr[j] - 1;
				count++;
			}

			if (count != 0)
				swap = swap + count - 1;
		}
		return swap;
	}
}
