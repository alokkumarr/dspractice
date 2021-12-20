package arrays;

// LC - Hard
public class FindMissingPositiveNumber {

    public static void main(String[] args) {
        int[] arr = {3, 12, 4, 1, 2, -1, 8};
        int missingNumber = missingPositiveNumber(arr);
        System.out.println("Missing Number : " + missingNumber);
    }

    private static int missingPositiveNumber(int[] arr) {
        int n = arr.length;
        if (n == 0) return 1;

        // Step 1 - mark out of range element and track one exist or not
        boolean isOneExist = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) isOneExist = true;
            else if(arr[i] < 1 || arr[i] > n) {
                arr[i] = 1;
            }
        }

        if (!isOneExist) return 1;

        // Step 2 - mark index value negative by element value
        for(int i = 0; i < n; i++) {
           int index = Math.abs(arr[i]);
           arr[index-1] = -Math.abs(arr[index-1]);
        }

        // Step 3 - Find the missing number by checking positive number then return index +1 else length array + 1
        for(int i = 0; i < n; i++) {
            if (arr[i] > 0) return i+1;
        }
        return n+1;
    }


}
