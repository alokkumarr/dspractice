package sort.gfg;

public class InterSectionOfTwoArray {
    public static void main(String[] args) {
        int[] a = {1,4,20,20,40,60};
        int[] b = {2,4,20,20,20};
        intersection(a, b);
    }


    private static void intersection(int[] a, int[] b) {
        int m = a.length, n = b.length, i =0, j=0;
        while (i < m && j< n) {

            if (i > 0 && a[i] == a[i-1]){
                i++;
                continue;
            }

            if (a[i] < b[j])
                i++;
            else if (a[i] > b[j])
                j++;
            else {
                System.out.println(a[i]);
                i++;
                j++;
            }


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
