package arrays;

public class ManagerTest {
    public static void main(String[] args) {
        int[] arr = {3,0,1};
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;

        int actual = 0;
        for(int a : nums) actual += a;

        int sum = (n*(n+1)) / 2;

        return sum - actual;
    }
}
