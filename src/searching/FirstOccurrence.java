package searching;

public class FirstOccurrence {

    public static void main(String[] args) {
        int[] array = {10,10,20,20,30,30,30,40,50};
        int k = 50;
        //int index = getFirstOccurrence(array, k);
        int index = getFirstOccRec(array, 0, array.length-1, k);
        System.out.println(index);
    }


    // O(log(n))
    private static int getFirstOccRec(int[] arr, int l, int r, int k) {
        if (l > r) return -1;
        int mid = (l + r)/2;
        if (k > arr[mid]) {
            return getFirstOccRec(arr, mid+1, r, k);
        } else if (k < arr[mid]) {
            return getFirstOccRec(arr, l, mid-1, k);
        } else if (mid ==0 || arr[mid-1] != arr[mid]){
            return mid;
        } else {
            return getFirstOccRec(arr, l, mid-1,k);
        }
    }


    /**
     * ~~O(n)
     * @param arr
     * @param k
     * @return
     */
    private static int getFirstOccurrence(int[] arr, int k){
        int l = 0, r = arr.length -1;
        while (l <= r){
            int mid = (l + r)/2;
            if (arr[mid] > k){
                r = mid -1;
            } else if (arr[mid] < k){
                l = mid + 1;
            } else if (mid == 0 || arr[mid] != arr[mid-1]){
                return mid;
            } else {
                r = mid -1;
            }
        }

        return -1;
    }
}
