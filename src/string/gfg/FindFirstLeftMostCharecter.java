package string.gfg;

import java.util.Arrays;

public class FindFirstLeftMostCharecter {
    public static void main(String[] args) {
        String str = "geeksforgeeks";

        // sloution 1st
        //findLeftMostSol1(str);

        //  solution 2
        int index = findLeftMostSol2(str);
        System.out.println(str.charAt(index));

        index = findLeftMostSol3(str);
        System.out.println(str.charAt(index));
    }

    // Visited from right side and build visited array
    private static int findLeftMostSol3(String str) {
        boolean[] visited = new boolean[256];
        //System.out.println(Arrays.toString(visited));

        int res = -1;

        for(int i = str.length()-1; i >= 0; i--) {
            if (visited[str.charAt(i)]) {
                res = i;
            } else {
                visited[str.charAt(i)] = true;
            }
        }
        return res;
    }

    // with one loop
    private static int findLeftMostSol2(String str) {
        int[] arr = new int[256];
        Arrays.fill(arr, -1);

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            int fi = arr[str.charAt(i)];
            if (fi == -1) {
                arr[str.charAt(i)] = i;
            } else {
                res = Math.min(res, fi);
            }
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    // with 2 for loop
    private static void findLeftMostSol1(String str) {
        int[] charArr = new int[256];

        for (int i = 0; i < str.length(); i++) {
            int chrindex = str.charAt(i);
            charArr[chrindex] += 1;
        }
        for (int i = 0; i < str.length(); i++) {
            if (charArr[str.charAt(i)] > 1) {
                System.out.println((char) str.charAt(i));
                return;
            }
        }
    }
}
