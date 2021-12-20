package leetcode;

public class SerachInRotatedSortedArray {

    public static void main(String[] args) {
        int[] array = {4,5,6,7,0,1,2, 0};
        int target = 0;
        System.out.println(search(array, target));
    }
    static public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        // binary search to find out correct position lie in the interval
        while (start <= end) {
            int mid = (start + end) / 2;
            // if mid itself a target search
            if (nums[mid] == target) return mid;

            // find the correct portion
            if (nums[start] <= nums[mid]) {
                // this one is the sorted array
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // this one is for unsorted array
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
