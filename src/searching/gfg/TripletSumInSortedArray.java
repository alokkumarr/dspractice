package searching.gfg;

public class TripletSumInSortedArray {

    public static void main(String[] args) {
        int[] arr = {2,3,4,8,9,20,40};
        boolean res = tripletSum(arr, 312    );
        System.out.println(res);
    }


    // this can only be solved in O(n^2)
    private static boolean tripletSum(int[] arr, int x) {

        for (int i = 0; i < arr.length - 2; i++) {

            // apply 2 pointer approach
            int tempSum = x - arr[i];
            int j = i + 1, k = arr.length - 1;
            while (j < k) {
                if (arr[j] + arr[k] == tempSum) {
                    return true;
                } else if (arr[j] + arr[k] > tempSum)
                    k--;
                else
                    j++;
            }
        }
        return false;
    }

}
