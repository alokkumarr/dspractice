package HackerRank.Array2D;

public class Hourglasses {
	public static void main(String[] args) {
		int[][] arr = new int[6][6];


		System.out.println(hourglassSum(arr));
	}

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] values) {
		int temp = 0;
		int max = Integer.MIN_VALUE;
		for (int i =0; i<4; i++){
			for (int j =0; j<4; j++){
				temp = values[i][j] + values[i][j+1] + values[i][j+2] 							// row 1
						  							 + values[i+1][j+1]															// row 2
								+ values[i+2][j] + values[i+2][j+1] + values[i+2][j+2]; 		// row 3

				max = Math.max(temp, max);
			}
		}

		return max;
	}
}
