package arrays;

import java.util.Arrays;

public class Merge2ArraySort {

    public static void main(String[] args) {
        int[] a1 = {1,3};
        int[] a2 = {2,4};

        int[] res = mergeTwoArray(a1, a2);
        System.out.println(Arrays.toString(res));

        float med = 0;
        int n = res.length;
        if (n % 2 > 0) {
            med = res[n/2];
            System.out.println("median of odd array : " + med);
        } else {
            med = (res[n/2]+ res[n/2 -1]);
            System.out.println("median of even array : " + med/2);
        }

        System.out.println(findMedianSortedArrays(a1, a2));

    }
    static int[] mergeTwoArray(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        int i =0, j = 0;
        int count =0;
        while (i < a.length && j < b.length) {
            if(a[i] <= b[j]) {
                merged[count] = a[i];
                count++;
                //System.out.println(a[i]);
                i++;
            } else {
                merged[count] = b[j];
                count++;
                //System.out.println(b[j]);
                j++;
            }
        }

        // remaining element of a if a has more element than b
        while (i < a.length) {
            merged[count] = a[i];
            count++;
            //System.out.println(a[i]);
            i++;
        }

        // remaining element of b if b has more element than a
        while (j < b.length) {
            merged[count] = b[j];
            count++;

            //System.out.println(b[j]);
            j++;
        }
        return merged;
    }

    /***
     *
     *
     * [1,3],
     * [2]
     *
     * [1,2]
     * [3,4]
     *
     * [0,0]
     * [0,0]
     *
     * []
     * [1]
     * [2]
     * []
     *
     *
     * 2.00000
     * 5.00000
     * 0.00000
     * 1.00000
     * 2.00000
     *
     * 2.00000
     * 2.50000
     * 0.00000
     * 1.00000
     * 2.00000
     *
     * @param a
     * @param b
     * @return
     */
    static double findMedianSortedArrays(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        int i =0, j = 0;
        int count =0;
        while (i < a.length && j < b.length) {
            if(a[i] <= b[j]) {
                merged[count] = a[i];
                count++;
                i++;
            } else {
                merged[count] = b[j];
                count++;
                j++;
            }
        }

        // remaining element of a if a has more element than b
        while (i < a.length) {
            merged[count] = a[i];
            count++;
            i++;
        }

        // remaining element of b if b has more element than a
        while (j < b.length) {
            merged[count] = b[j];
            count++;
            j++;
        }

        float med = 0;
        int n = merged.length;
        if (n % 2 > 0) {
            med = merged[n/2];
        } else {
            med = (merged[n/2]+ merged[n/2 -1]);
            med = med/2;
        }
        return med;
    }

}
