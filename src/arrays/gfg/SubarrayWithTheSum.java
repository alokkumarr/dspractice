package arrays.gfg;

public class SubarrayWithTheSum {
    public static void main(String[] args) {
        int[] arr = {1,4,20,3,10,5};//{3,2,0,4,7};
        boolean res = solutionBest(arr, 33);
        System.out.println(res);
    }

    // naive solution
    // o(n^2)
    private static boolean solution(int[] arr, int sum) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = 1; j < n; j++) {
                curr += arr[j];
                if (curr == sum)
                    return true;
            }
        }
        return false;
    }

    private static boolean solutionBest(int[] arr, int sum) {
        int n = arr.length;
        int start = 0;
        int curr = 0;
        for (int end = 0; end < n; end++) {
            curr += arr[end]; // add to current until its greater to sum

            // remove from starting
            while (sum < curr) {
                curr -= arr[start];
                start++;
            }

            if (curr == sum)
                return true;
        }
        return false;
    }
}