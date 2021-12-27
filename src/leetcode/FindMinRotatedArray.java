package leetcode;

public class FindMinRotatedArray {

    public int findMin(int[] nums) {
        if (nums == null) return  -1;
        if (nums.length == 1) return nums[0];

        int left = 0;
        int right = nums.length - 1;

        // binary search manipulation
        while (left < right) {
            int mid = left + (right - left) / 2;

            // check for manipulation point
            if (mid > 0 && nums[mid] < nums[mid - 1])
                return nums[mid];

            // discard the sorted section
            if (nums[left] <= nums[mid] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }
}
