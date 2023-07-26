package heap.gfg;

import java.util.PriorityQueue;

public class BuyMaximumItemGivenSum {

    public static void main(String[] args) {
        int[] cost = {1,12,5,111,100};
        int sum = 10;

        int maxItem = maxItemBuy(cost, sum);
        System.out.println("Maximum item can be buyed : " + maxItem);
    }


    /*    O(n) + O(res*logn)   */
    private static int maxItemBuy(int[] cost, int sum) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j : cost) {
            pq.add(j);
        }
        /* {1,12,5,111,100}
         *
         *  Min Priority Queue
         *
         *                   1
         *                /    \
         *              12      5
         *            /   \
         *          111    100
         *
         *  Now remove the item from PQ and adjust the sum by subtracting the element
         *  and increase the sum.
         *
         */
        while (!pq.isEmpty()) {
            sum = sum - pq.poll();
            if (sum >= 0) {
                res++;
            }
        }
        return res;
    }
}
