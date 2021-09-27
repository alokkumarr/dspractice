package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        //O/P -  1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
        int r = 4, c = 4;
        printSpiralFormat(arr);
        System.out.println("---------------------------");
        System.out.println(printSpiral(arr));
    }

    private static List<Integer> printSpiral(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List ans = new ArrayList<>();

        int startrow = 0 , endrow = n-1 , startcol = 0 , endcol = m-1;

        while(startcol <= endcol && startrow <= endrow) {
            // start row
            for(int j = startcol ; j<=endcol ; j++) {
                ans.add(matrix[startrow][j]);
            }

            // end col
            for(int j = startrow+1 ; j<=endrow ; j++) {
                ans.add(matrix[j][endcol]);
            }

            // end row
            for(int j = endcol-1 ; j>=startrow ; j--) {
                if(startrow == endrow) {
                    break;
                }
                ans.add(matrix[endrow][j]);
            }

            // start col
            for(int j = endrow-1 ; j>=startrow+1 ; j--) {
                // Avoids duplicate printing of elements
                if(startcol == endcol) {
                    break;
                }
                ans.add(matrix[j][startcol]);
            }

            // variable updated
            startrow++;
            endrow--;
            startcol++;
            endcol--;
        }
        return ans;
    }

    private static void printSpiralFormat(int[][] arr) {
        List<Integer> result = new ArrayList<>();
        int top =0, left = 0, right = arr.length - 1, bottom = arr[0].length -1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(arr[top][i]);
                //System.out.print(arr[top][i] + " ");
            }
            top++;

            for (int i = top; i <=bottom; i++) {
                result.add(arr[i][right]);
                //System.out.print(arr[i][right] + " ");
            }
            right --;

            if (top <= bottom) {
                for (int i = right; i >= left; i--){
                    result.add(arr[bottom][i]);
                    //System.out.print(arr[bottom][i] + " ");
                }
                bottom--;
            }

            if (left <= right){
                for (int i = bottom; i >= top; i --) {
                    result.add(arr[i][left]);
                    //System.out.print(arr[i][left] + " ");
                }
                left++;
            }
        }
        System.out.println(result);
    }
}
