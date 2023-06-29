package searching.gfg;

public class PairsOfGivenSum {
    public static void main(String[] args) {
        int[] arr = {2,5,8,12,30};
        boolean res = getPairsBest(arr, 171);
        System.out.println(res);
    }

    // O(n) - Time, O(1) - Space
    private static boolean getPairsBest(int[] arr, int sum) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
           if (arr[i] + arr[j] == sum)
               return true;
           else if (arr[i] + arr[j] < sum)
               i++;
           else
               j--;
        }
         return false;
    }
    // O(n^2) - O(1)
    private static boolean getPairs(int[] arr, int sum) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum)
                    return true;
            }
        }
        return false;
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
