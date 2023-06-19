package reccursion;

public class PrintNumber {

    public static void main(String[] args) {
        int num = 5;
        //printNToOne(num);
        //System.out.println("-----");
        //printOneToN(num);
        printerOneToNTrailRecursion(num, 1);
    }

    private static void printNToOne(int num) {
        if (num == 0) return;
        System.out.println(num);
        printNToOne(num-1);
    }

    private static void printOneToN(int n) {
        if (n == 0)
            return;
        printOneToN(n - 1);
        System.out.println(n);
    }

    public static void printerOneToNTrailRecursion(int n, int k) {
        if (n == 0)
            return;

        System.out.println(k + " ");
        printerOneToNTrailRecursion(n - 1, k+1);
    }
}
