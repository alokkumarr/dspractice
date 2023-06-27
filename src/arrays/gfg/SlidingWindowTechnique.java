package arrays.gfg;

public class SlidingWindowTechnique {
    public static void main(String[] args) {
        int[] arr = {1,8,3,-5,20,7};
        int res = solution(arr, 4);
        System.out.println(res);
    }

    private static int solution(int[] arr, int k) {
        int cur = 0; int n = arr.length;
        for (int i = 0; i < k; i++) {
            cur += arr[i];
        }

        int res = cur;
        for (int i = k; i < n; i++) {
            cur = cur - arr[i-k] + arr[i];
            res = Math.max(res, cur);
        }
        return res;
    }
}
