package heap;

import java.util.PriorityQueue;

public class BuyMaximumItemGivenSum {
    public static void main(String[] args) {
        int[] cost = {1,12,5,111,100};
        int sum = 10;
        int maxItem = maxItemBuy(cost, sum);
        System.out.println("Maximum item can be buyed : " + maxItem);
    }

    private static int maxItemBuy(int[] cost, int sum) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0 ; i < cost.length; i++) {
            pq.add(cost[i]);
        }

        while (!pq.isEmpty()) {
            sum = sum - pq.poll();
            if (sum >= 0) {
                res++;
            }
        }
        return res;
    }
}
