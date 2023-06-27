package arrays.gfg;

/**
 * Leader in array means any element in the array right side is less that the current element.
 */
public class FindSortedArrayFrequency {
    public static void main(String[] args) {
        int[] arr = {3,3,5,7,7,7,10,20,20};
        bestSolution(arr);
        //System.out.println(res);
    }

    private static void bestSolution(int[] arr) {
        int n = arr.length;
        int frequency = 1;
        int i = 1;
        while (i < n) {
            while (i < n && arr[i] == arr[i-1]) { //{3,3,5,7,7,7,10,20,20}
                frequency++;
                i++;
            }
            System.out.println(arr[i-1] + " : " + frequency);
            i++;
            frequency = 1;
        }
        if (n == 1 || arr[n-1] != arr[n-2]) {
            System.out.println(arr[n-1] + " : " + 1);
        }
    }
}
