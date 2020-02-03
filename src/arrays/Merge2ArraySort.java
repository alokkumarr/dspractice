package arrays;

public class Merge2ArraySort {

    private static void mergeTwoArray(int[] a, int[] b) {
        //int[] sortedArr = new int[a.length + b.length];
        int i =0, j = 0;
        while (i < a.length && j < b.length) {
            if(a[i] <= b[j]) {
                System.out.println(a[i]);
                i++;
            } else {
                System.out.println(b[j]);
                j++;
            }
        }

        // remaining element of a if a has more element than b
        while (i < a.length) {
            System.out.println(a[i]);
            i++;
        }

        // remaining element of b if b has more element than a
        while (j < b.length) {
            System.out.println(b[j]);
            j++;
        }
    }



}
