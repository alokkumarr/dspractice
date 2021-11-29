package searching;

public class FindEquilibriumPoint {
    public static void main(String[] args) {
        int[] arr = {3,4,8,-9,20,6};
        int point = findEquilibrium(arr);
        System.out.println("Equilibrium point : " + point);
    }

    // O(n) - time complexity and O(1) - extra space
    private static int findEquilibrium(int[] arr) {
        int sum = 0;
        for (int a : arr) sum += a;
        int lSum = 0;
        for (int i=0; i < arr.length; i++) {
            if (lSum == sum - arr[i]) {
                return i;
            }
            lSum += arr[i];
            sum -= arr[i];
        }
        return -1;
    }
}
