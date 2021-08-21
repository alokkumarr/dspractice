package searching;

public class LastOccurrence {

    public static void main(String[] args) {
        int[] array = {10,10,20,20,30,30,30,40,50};
        int k = 20;
        int n = array.length-1;
        int index = getLastOccurrence(array, k);
        //int index = getLastOccRec(array, 0, n, k, n);
        System.out.println(index);
    }


    // O(log(n))
    private static int getLastOccRec(int[] arr, int l, int r, int k, int n) {
        if (l > r) return -1;
        int mid = (l + r)/2;
        if (k > arr[mid]) {
            return getLastOccRec(arr, mid+1, r, k, n);
        } else if (k < arr[mid]) {
            return getLastOccRec(arr, l, mid-1, k, n);
        } else if (mid == n || arr[mid] != arr[mid+1]){
            return mid;
        } else {
            return getLastOccRec(arr, mid+1, r, k, n);
        }
    }


    /**
     * ~~O(n)
     * @param arr
     * @param k
     * @return
     */
    private static int getLastOccurrence(int[] arr, int k){
        int n = arr.length -1;
        int l = 0, r = n;
        while (l <= r){
            int mid = (l + r)/2;
            if (arr[mid] > k){
                r = mid -1;
            } else if (arr[mid] < k){
                l = mid + 1;
            } else if (mid == n || arr[mid] != arr[mid+1]){
                return mid;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }
}
