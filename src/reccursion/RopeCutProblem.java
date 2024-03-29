package reccursion;

/**
 * find the max number of cut with the given rope and ways to cut the rope by length.
 */
public class RopeCutProblem {

    public static void main(String[] args) {
        int str = 9;
        int res = fun(str, 2, 3, 2);
        System.out.println(res);
    }

    /**
     *                          9
     *                        / | \
     *                       7  7 7
     *                     /|\
     *                    5 5 5
     *                   /  |  \
     *                   3  3  3
     *                / | \
     *               1  1  1
     *              /   |   \
     *             -Ve  -ve  -ve
     */


    private static int fun(int n, int a, int b, int c) {
       if(n == 0)
           return 0;

       if (n < 0)
           return -1;

       // build a recursive tree
       int res = Math.max(
               Math.max(fun(n - a, a, b, c), fun(n - b, a, b, c))
               , fun(n-c, a, b, c));

       if (res == -1)
           return -1;

       return res + 1;
    }
    
}
