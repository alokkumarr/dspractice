package string;

import java.util.Arrays;

public class FirstLeftRepeatableChar {
    public static void main(String[] args) {
        String str = "abcdhbmsndsn";
        System.out.println(leftMostRepeatableCharSol(str));
    }

    private static int leftMostRepeatableCharSol(String str) {
        int[] fIndex = new int[256];
        Arrays.fill(fIndex, -1);
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) {
            int fi = fIndex[str.charAt(i)];
            if (fi == -1) {
                fIndex[str.charAt(i)] = i;
            } else {
                result = Math.min(result, fi);
            }
        }
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }


    private static void leftMostRepeatableChar(String str) {
        int[] count = new int[256];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        for (int i = 0; i<count.length; i++) {
            if (count[i] > 1) {
                System.out.println((char) i);
                break;
            }
        }
    }
}
