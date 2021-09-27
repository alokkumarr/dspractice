package arrays;

public class StockBuySellProblem {
    public static void main(String[] args) {
        int[] arr = {7,6,4,3,1};
        int result = maxProfit(arr);
        System.out.println("Result : " + result);
    }

    private static int maxProfit(int[] nums) {
        int minPrice = nums[0];
        int profit = 0;
        for (int i = 1; i < nums.length; i++) {
            profit = Math.max(profit, nums[i] - minPrice);
            minPrice = Math.min(minPrice, nums[i]);
        }
        return profit;
    }
}
