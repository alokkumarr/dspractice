package arrays;

public class PrifixSumTecqnique {
    public static void main(String[] args) {
        int[] arr = {2, 8, 3, 9, 6, 5, 4};
        int k = 2;
        int maxSum = prefixSum(arr, k);
        System.out.println("Max sum : " + maxSum);

        //arr = new int[]{3, 4, 8, -9, 20, 6};
        arr = new int[]{2,1,-1};
        int point = findEquilibriumPoint(arr);
        System.out.println("Equilibrium point : " + point);
    }

    private static int prefixSum(int[] arr, int k) {
        int prefixSum = 0;
        for (int i = 0; i < k; i++) {
            prefixSum += arr[i];
        }
        int maxRes = prefixSum;
        for (int i = k; i < arr.length; i++) {
            prefixSum += arr[i] - arr[i - k];
            maxRes = Math.max(maxRes, prefixSum);
        }
        //System.out.println("Max sum of " + k + " is : " + maxRes);
        return maxRes;
    }

    private static int findEquilibriumPoint(int[] nums) {
        int pivot = -1;
        int sum = 0;
        for(int i : nums) sum += i;

        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (prefixSum == (sum - nums[i])) {
                pivot = i;
                break;
            } else {
                prefixSum += nums[i];
                sum -= nums[i];
            }
        }
        //System.out.println("Equilibrium point : "+pivot);
        return pivot;
    }

}