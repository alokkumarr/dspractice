package searching;

public class Count1stInBinaryArray {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,1,1,1,1,1,1,1,1,1};
        int count = countOneArray(arr);
        System.out.println("No of 1st in array : " + count);
    }

    // O(nlogn)
    private static int countOneArray(int[] arr) {
        int low = 0, n = arr.length, high = arr.length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == 0) {
                low = mid + 1;
            } else {
                // this will decide the first 1s in an array
                if (mid == 0 || arr[mid-1] == 0) {
                    return n - mid ;
                } else {
                    high = mid - 1;
                }
            }
        }
        return 0;
    }
}
