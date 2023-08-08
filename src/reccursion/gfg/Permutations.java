package reccursion.gfg;

public class Permutations {
    public static void main(String[] args) {
        String str = "ABCD";

        permuate(str);
    }

    private static void permuate(String str) {
        // index position to be start with 0
        permuateString(str, 0);
    }

    private static void permuateString(String str, int i) {
        if (i == str.length()-1) {
            System.out.print(str + " ");
            return;
        }

        for (int j = i; j < str.length(); j++) {
            str = swap(str, i, j);
            permuateString(str, i+1);
            str = swap(str, j, i);
        }

    }

    static String swap(String str, int l, int r) {
        char[] chars = str.toCharArray();
        char tmp = chars[l];
        chars[l] = chars[r];
        chars[r] = tmp;
        return String.valueOf(chars);
    }
}
