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
        // generate subset by using the index value

        subset(str, "", 0);
    }

    private static void subset(String str, String curr, int i) {

        // every time check the index with the new string
        if (i == str.length()) {
            System.out.println(curr);
            return;
        }

        // The idea is to consider two cases for every character.
        // (i) Consider current character as part of the current subset
        // (ii) Do not consider current character as part of the current subset.
        subset(str, curr, i + 1);
        subset(str, curr + str.charAt(i), i+1);
    }
}
