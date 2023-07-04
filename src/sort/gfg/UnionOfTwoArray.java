package sort.gfg;

public class UnionOfTwoArray {
    public static void main(String[] args) {
        int[] a = {2,10,20,20};
        int[] b = {3,20,40};
        union(a, b);
    }


    private static void union(int[] a, int[] b) {
        int m = a.length, n = b.length, i =0, j=0;
        while (i < m && j< n) {
            // Avoid duplicate comparision in first array
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            // Avoid duplicate comparision in second array
            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }

            if (a[i] < b[j]) {
                System.out.print(a[i] + " ");
                i++;
            } else if (a[i] > b[j]){
                System.out.print(b[j]+" ");
                j++;
            } else {
                System.out.print(a[i]+" ");
                i++;
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


    private static void solution(int[] a, int[] b) {
        int m = a.length, n = b.length;
        for (int i = 0; i < m; i++) {
            if (i > 1 && a[i] == a[i-1])
                continue;

            for (int j = 0; j < n; j++) {
                if (a[i] == b[j]) {
                    System.out.println(a[i]);
                    break;
                }
            }
        }
    }
}
