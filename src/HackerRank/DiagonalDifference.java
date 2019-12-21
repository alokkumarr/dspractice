package HackerRank;

public class DiagonalDifference {

	private static int diagonalDifference(int[][] arr) {
		int leftSum = 0, rightSum = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			leftSum += arr[i][i];
			rightSum += arr[i][n - 1 - i];
		}
		return Math.abs(leftSum - rightSum);
	}

}
