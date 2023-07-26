package string.gfg;

import java.util.Arrays;

public class FindFirstLeftNonOccurence {
    public static void main(String[] args) {
        String str = "geeksforgeeks";

        // sloution 1st
        findLeftMostSol1(str);

        int index = findLeftNonOccurence(str);
        System.out.println(index);
    }

    private static int findLeftNonOccurence(String str) {
        int[] charArr = new int[256];
        Arrays.fill(charArr, -1);

        for (int i = 0; i < str.length(); i++) {
            int findex = charArr[str.charAt(i)];
            if (findex == -1) {
                charArr[str.charAt(i)] = i;
            } else {
                charArr[str.charAt(i)] = -2;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] > 0) {
                res = Math.min(res, charArr[i]);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // with 2 for loop
    private static void findLeftMostSol1(String str) {
        int[] charArr = new int[256];

        for (int i = 0; i < str.length(); i++) {
            int chrindex = str.charAt(i);
            charArr[chrindex] += 1;
        }
        for (int i = 0; i < str.length(); i++) {
            if (charArr[str.charAt(i)] == 1) {
                System.out.println((char) str.charAt(i));
                return;
            }
        }
    }
}
