package dynamicprogramming.gfg;

/*
The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence
such that all elements of the subsequence are sorted in increasing order.
For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {10,20,9,33,21,50,41,60,80};

        //op - 10,20,21,41,60,80

        int res = lis(arr, arr.length);
        System.out.println(res);

        res = lisDP(arr, arr.length);
        System.out.println(res);
    }

    // O(nlogn) - Time, O(n) - Space
    private static int lisDP(int[] arr, int n) {
        int[] tail = new int[n];
        tail[0] = arr[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > tail[len-1]) {
                tail[len] = arr[i];
                len++;
            } else {
                int c = ceil(tail, 0, len-1, arr[i]);
                tail[c] = arr[i];
            }
        }
        return len;
    }

    // find the just greater element in tail array
    private static int ceil(int[] tail, int left, int right, int data) {
        while (right > left) {
            int m = left + (right-left) / 2;
            if (tail[m] >= data) {
                right = m;
            } else {
                left = m+1;
            }
        }
        return right;
    }


    // O(n^2)  - Time , space - O(n)
    private static int lis(int[] arr, int n) {
        int[] lis = new int[n];
        lis[0] = 1;

        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
        }

        // find the max in the array is the result
        int res = lis[0];
        for (int i = 0; i < n; i++) {
            res = Math.max(res, lis[i]);
        }
        return res;
    }
}
