package arrays;

public class StockBuySellProblem {
    public static void main(String[] args) {
        int[] arr = {7,6,4,3,11};
        int result = maxProfit(arr);
        System.out.println("Result : " + result);
    }

    private static int maxProfit(int[] nums) {
        int profit = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                profit = profit + (nums[i] - nums[i-1]);
            }
        }
        return profit;
    }
}
