package dynamicprogramming.gfg;

import java.util.Arrays;

public class DPTabulization {
    public static void main(String[] args) {
        int num = 5;

        int res = factTab(num);
        System.out.println(res);
    }

    private static int factTab(int num) {
        int[] f = new int[num+1];

        f[0] = 0; f[1] = 1;

        for (int i = 2; i <= num; i++) {
            f[i] = f[i-1] + f[i-2];
        }

        return f[num];
    }
}
