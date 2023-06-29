package searching.gfg;

public class PeackElelment {
    public static void main(String[] args) {
        int[] arr = {5,10,20,40,60,80,70 };
        int res = getPeak(arr, arr.length);
        System.out.println( + arr[res]);
    }

    private static int getPeak(int[] arr, int n) {
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = (low + high)/2;

            if((mid == 0 || arr[mid] >= arr[mid - 1])
                && (mid == n-1 || arr[mid] >= arr[mid+1])) {
                return mid;
            }

            if (mid > 0 && arr[mid] <= arr[mid-1]) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static void solution(int[] arr, int n) {
        if (n == 1) System.out.println(arr[0]);
        if (arr[0] > arr[1]) System.out.println(arr[0]);
        if (arr[n-1] > arr[n-2]) System.out.println(arr[n-1]);

        for (int i = 1; i < n-1; i++) {
            if (arr[i] >= arr[i-1] && arr[i] >= arr[i+1])
                System.out.println(arr[i]);
        }
    }

}
