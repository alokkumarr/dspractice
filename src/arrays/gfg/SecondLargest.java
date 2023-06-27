package arrays.gfg;

public class SecondLargest {

    public static void main(String[] args) {
        int[] arr = {12,12,12,8};
        int result = largestSecond(arr);
        System.out.println("Result index : " + result + " and the value : " + arr[result]);
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
