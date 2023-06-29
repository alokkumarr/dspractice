package searching.gfg;

public class FindOccurence {
    public static void main(String[] args) {
        int[] arr = {5,10,10,10,10,20,20};
        int res = findLastOccurenceIterative(arr, 0, arr.length, 10);
        System.out.println("Index : " + res);
    }


    private static int findLastOccurenceIterative(int[] arr, int low, int high, int x) {

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                if (mid == arr.length -1 || arr[mid] != arr[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }

        }
        return -1;
    }



    private static int findFirstOccurenceIterative(int[] arr, int low, int high, int x) {

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid] != arr[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;
    }

    private static int findFirstOccurence(int[] arr, int low, int high, int x) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        if (arr[mid] > x) {
            return findFirstOccurence(arr, low, mid-1, x);
        } else if (arr[mid] < x) {
            return findFirstOccurence(arr, mid + 1, high, x);
        } else {
            if (mid == 0 || arr[mid] != arr[mid - 1]) {
                return mid;
            } else {
                return findFirstOccurence(arr, low, mid-1, x);
            }
        }
    }
}
