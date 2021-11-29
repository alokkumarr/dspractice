package arrays;

/**
 * Moores algorithim
 * 1) find the majority elements
 * 2) find the number of occurrence
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2,3,10,6,4,50,8,1};
        int result = maxDifference(arr);
        System.out.println("Result : " + result);
    }

    private static int maxDifference(int[] arr) {
        int res = 0;
        int count = 1;

        // find the majority element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                count++;
            } else {
                count --;
            }

            if (count == 0) {
                res = i;
                count = 1;
            }
        }

        // find the actual count
        count = 0;
        for (int element : arr) {
            if (arr[res] == element) count++;
        }
        if (count < arr.length/2) return -1;
        return res;
    }
}
