package sort.gfg;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] a = {10,20,50};
        int[] b = {15,21,60, 80};
        mergeAndPrint(a, b);
    }

    private static void mergeAndPrint(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int i = 0, j = 0;
        while (i < m && j< n) {
            if (a[i] <= b[j]) {
                System.out.print(a[i] + " ");
                i++;
            } else {
                System.out.print(b[j] + " ");
                j++;
            }
        }

        // print first array element
        while (i < m) {
            System.out.print(a[i] + " ");
            i++;
        }

        // print second array element
        while (j< n) {
            System.out.print(b[j] + " ");
            j++;
        }
    }
}
