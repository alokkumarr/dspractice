package reccursion;

/**
 * find the max number of cut with the given rope and ways to cut the rope by length.
 */
public class GenerateSubset {

    public static void main(String[] args) {
        String str = "ABC";
        fun(str);
        //System.out.println(res);
    }

    private static void fun(String str) {
        subset(str, "", 0);
    }

    private static void subset(String str, String curr, int i) {
        if (i == str.length()) {
            System.out.println(curr);
            return;
        }

        subset(str, curr, i + 1);
        subset(str, curr + str.charAt(i), i+1);
    }
}
