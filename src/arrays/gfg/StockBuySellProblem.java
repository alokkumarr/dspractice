package arrays.gfg;

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
                profit += nums[i] - nums[i-1];
            }
        }
        return profit;
    }

    static int maxProfit(int[] arr, int start, int end) {
        if (end < start) return 0;
        int profit = 0;
        for (int i = start; i< end; i++) {
            for (int j = i+1; j <= end; j++) {
                if (arr[j] > arr[i]) {
                    int curProf = (arr[j] - arr[i])
                            + maxProfit(arr, start, i-1)
                            +maxProfit(arr, j+1, end);

                    profit = Math.max(profit, curProf);
                }
            }
        }

        return profit;
    }
}
