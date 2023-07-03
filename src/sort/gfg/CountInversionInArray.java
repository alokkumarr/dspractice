package sort.gfg;

public class CountInversionInArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        int res = naiveSolution(arr);
        System.out.println(res);
    }

    private static int naiveSolution(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j])
                    res++;
            }
        }
        return res;
    }
}
