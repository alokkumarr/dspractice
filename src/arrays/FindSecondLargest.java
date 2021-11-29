package arrays;

public class FindSecondLargest {

    public static void main(String[] args) {
        int[] arr = {2,3,10,6,4,50,8,1};
        int result = largestSecond(arr);
        System.out.println("Result : " + result);
    }

    private static int largestSecond(int[] arr) {
        int res = -1, largest = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[largest]) {
                res = largest;
                largest = i;
            } else if(arr[i] != arr[largest]){
                if (res == -1 || arr[i] > arr[res]) {
                    res = i;
                }
            }
        }
        return res;
    }
}
