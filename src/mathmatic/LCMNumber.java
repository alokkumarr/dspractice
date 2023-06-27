package mathmatic;

public class LCMNumber {
    public static void main(String[] args) {
        int lcm = findLCM(4, 6);
        System.out.println(lcm);
    }

    private static int findLCM(int a, int b) {
        int res = Math.max(a, b);

        while (true) {
            if (res % a == 0 && res % b ==0) {
                return res;
            }
            res ++;
        }
    }

}
