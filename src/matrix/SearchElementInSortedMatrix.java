package matrix;

public class SearchElementInSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int x = 13;
        searchElements(arr,x);
    }

    private static void searchElements(int[][] matrix, int key) {
        int r = matrix.length, c = matrix[0].length;
        int i = 0, j = c-1;
        while (i < r && j >= 0) {
            if (matrix[i][j] == key) {
                System.out.println("(" + i + "," + j + ")");
                break;
            } else if (matrix[i][j] > key) {
                j--;
            } else {
                i++;
            }
        }
    }
}
