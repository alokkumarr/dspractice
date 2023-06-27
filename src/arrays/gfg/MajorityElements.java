package arrays.gfg;

public class MajorityElements {
    public static void main(String[] args) {
        int[] arr = {8,7,6,8,6,6,6,6};

        //majorityElements(arr);
        int res = majorityElementsBest(arr);
        System.out.println(res);
    }

    // O(n^2)
    private static void majorityElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > arr.length/2) {
                System.out.println("Index : " + i);
            }
        }
    }

    // O(n)
    private static int majorityElementsBest(int[] arr) {
        int res = 0; int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[res]) {
                count++;
            } else {
                count--;
            }

            // reset the values if count is zero
            if (count == 0) {
                res = i;
                count =1;
            }
        }


        // check if the element is really a majority element
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[res] == arr[i]) {
                count++;
            }

            if (count < arr.length/2) {
                res = -1;
            }
            return res;
        }
        return res;
    }
}
