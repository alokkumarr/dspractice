package arrays.gfg;

/**
 * Leader in array means any element in the array right side is less that the current element.
 */
public class LeaderInAnArray {
    public static void main(String[] args) {
        int[] arr = {7,10,4,3,6,5,2};

        int res1 = naiveSolution(arr);
        System.out.println(res1);

        bestSolution(arr);
        //System.out.println("Best Solution : " + res);
    }

    private static void bestSolution(int[] arr) {
        int n = arr.length-1;
        int currLeader = arr[n];
        System.out.print(currLeader + " ");
        for (int i = n-1; i >= 0; i--) {
            if(currLeader < arr[i]) {
                currLeader = arr[i];
                System.out.print(currLeader + " ");
            }
        }
    }

    private static int naiveSolution(int[] arr) {
        return 0;
    }
}
