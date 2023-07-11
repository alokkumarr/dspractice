package stack.gfg;

public class HistogramArea {
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 1, 5, 6};
        int n = getMaxArea(arr);
        System.out.println("Max area of histogram : " + n);
    }

    public static int getMaxArea(int arr[]) {
        int res = 0;
        int[] ps = PreviousGreater.solutionPrevGreater(arr);
        System.out.println();

        int[] ns = PreviousGreater.solutionGreater(arr);
        System.out.println();

        for(int i=0; i<arr.length; i++){
            int curr=arr[i];
            curr += (i-ps[i]-1)*arr[i];
            curr += (ns[i]-i-1)*arr[i];
            res=Math.max(res,curr);
        }
        return res;
    }
}
