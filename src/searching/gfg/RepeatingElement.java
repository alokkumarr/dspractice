package searching.gfg;

public class RepeatingElement {

    /**
     * All element from 1 to max(arr) are present
     * 1<= max[arr] < n-1
     *
     */
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,3,3};
        int element = solution(arr);
        System.out.println(element);
    }

    private static int solution(int[] arr) {
        int slow = arr[0], fast = arr[0];
        // phase 1 - move slow 1 and fast to 2
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // phase 2 - move both at 1 place
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }


}
