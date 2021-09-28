package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrefixSumRangeTecqnique {
    public static void main(String[] args) {
        int[] arr1 = {1,2,5,15};
        int[] arr2 = {5,8,7,18};
        maxOccurredElement(arr1, arr2);
    }

    private static int maxOccurredElement(int[] lr, int[] rr) {
        int[] list = new int[50];
        System.out.println("Default data : " + list[1]);

        //{1,2,3}
        for (int i = 0; i < lr.length; i++) {
            list[lr[i]]++;
        }
        System.out.println(Arrays.toString(list));

        // {3,4,5}
        for (int i = 0; i < rr.length; i++) {
            list[rr[i] + 1]--;
        }
        System.out.println(Arrays.toString(list));

        int maxElement = list[0];
        int elementIndex = 0;
        for (int i = 1; i < list.length; i++) {
            list[i] += list[i-1];
            if (maxElement < list[i]) {
                maxElement = list[i];
                elementIndex = i;
            }
        }
        System.out.println(Arrays.toString(list));
        System.out.println("Element : " + elementIndex + " has occurred max : " + maxElement + " times");

        return maxElement;
    }

}