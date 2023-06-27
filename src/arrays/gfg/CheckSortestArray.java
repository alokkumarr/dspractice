package arrays.gfg;

public class CheckSortestArray {

    public static void main(String[] args) {
        int[] arr = {12,12,12,14};
        boolean result = checkSorted(arr);
        System.out.println("Result sorted : " + result);
    }

    private static boolean checkSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1])
                return false;
        }
        return true;
    }


    private static int largestSecond(int[] arr) {
        int res = -1, largest = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[largest]) {
                res = largest;
                largest = i;
            } else if (arr[i] != arr[largest]){
                if (res == -1 || arr[i] > arr[largest])
                    res = i;
            }
        }
        return res;
    }
}
