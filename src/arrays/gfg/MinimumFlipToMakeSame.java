package arrays.gfg;

import java.util.Arrays;

public class MinimumFlipToMakeSame {

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,0, 0, 1, 1,0};
        solution(arr);
        //System.out.println(Arrays.toString(arr));
    }

    private static void solution(int[] arr) {
        for (int i = 1; i<arr.length; i++) {
            if (arr[i] != arr[0]) {
                System.out.print("From " + i + " to ");
            } else {
                System.out.print(i-1 + " end");
            }
        }

        if (arr[arr.length-1] != arr[0]) {
            System.out.print(arr.length-1);
        }
    }
}
