package arrays.gfg;

public class EquilibriumPoint {
    public static void main(String[] args) {
        int[] arr = {3,4,8,-9,9,7};
        boolean isHave = solutionNaive(arr);
        System.out.println("Have Equilibrium : " + isHave );
    }


    // O(n) - Time , O(1) - Space
    private static boolean solution(int[] arr) {
        int rs = 0;
        for(int i = 0; i< arr.length; i++)
            rs += arr[i];

        int ls = 0;
        for(int i = 0; i< arr.length; i++) {
            rs -= arr[i];
            if (ls == rs)
                return true;

            ls += arr[i];
        }

        return false;
    }


    // O(n^2) , Space = O(1)
    private static boolean solutionNaive(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int ls = 0, rs = 0;

            // get left sum
            for (int j = 0; j < i; j++)
                ls += arr[j];

            // get right sum
            for (int k = i + 1; k < n; k++)
                rs += arr[k];

            if (ls == rs)
                return true;
        }
        return false;
    }
}
