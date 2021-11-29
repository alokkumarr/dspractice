package searching;

public class SquareRoot {
    public static void main(String[] args) {
        int number = squareRoot(9);
        System.out.println(number);
    }

    // O(logn)
    private static int squareRoot(int x) {
        int low = 1, high = x, ans = -1;
        while (low <= high) {
            int mid = (low+high)/2;
            int sqrt = mid * mid;
            if (x == sqrt) {
                return mid;
            } else if (x > sqrt) {
                low = mid + 1;
                //ans = mid;
            } else {
                high = mid -1;
            }
        }
        return ans;
    }
}
