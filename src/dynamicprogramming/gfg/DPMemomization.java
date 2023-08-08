package dynamicprogramming.gfg;

import java.util.Arrays;

public class DPMemomization {
    public static void main(String[] args) {
        int num = 5;

        Arrays.fill(memo, -1);
        int res = factMemo(num);
        System.out.println(res);
    }

    static int[] memo = new int[6];
    private static int factMemo(int num) {
        if (memo[num] == -1) {
            int res;
            if (num == 0 || num == 1)
                res = num;
            else
            res = factMemo(num-1) + factMemo(num-2);

            memo[num] = res;
        }

        return memo[num];
    }
}
