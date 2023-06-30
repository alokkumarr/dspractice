package searching.gfg;

public class SortedRotatedSerach {
    public static void main(String[] args) {
        int[] arr = {10,20,40,60,5,8,9};
        int res = findElement(arr, arr.length, 6);
        System.out.println("Index : " + res);
    }


    private static int findElement(int[] arr, int n, int x) {
        int low = 0, high = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) return mid;

            // left side
            if (arr[mid] >= arr[low]) {
                if (x >= arr[low] && x < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // right side
                if (x > arr[mid] && x <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid -1;
                }
            }
        }
        return -1;
    }
}
