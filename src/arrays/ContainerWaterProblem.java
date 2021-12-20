package arrays;


import java.util.Arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 */
public class ContainerWaterProblem {

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(Arrays.toString(arr));
        System.out.println("--------------------------");
        System.out.println(maxArea(arr));
    }
    static public int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;

        int maxArea = 0;
        // this is O(n) solution
        while (left < right) {
            int lHeight = height[left];
            int rHeight = height[right];
            int minHeight = Math.min(lHeight, rHeight);
            int curArea = minHeight * (right - left);
            maxArea = Math.max(maxArea, curArea);
            if (lHeight < rHeight) left++;
            else right--;
        }
        return maxArea;
    }
}
