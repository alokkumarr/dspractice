package matrix;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        //O/P -  1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
        printTranspose(arr);
    }

    private static void printTranspose(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
           for (int j = i+1; j< arr[i].length; j++) {
               swap(arr , i, j);
           }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j< arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }
}
