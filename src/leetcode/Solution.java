package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};

    System.out.println(threeSum(nums));
  }


  public static List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> seen = new HashSet<>();
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i=0; i< nums.length-2; ++i){
      int l = i+1;
      int r = nums.length-1;

      while (l < r){
        int target = -nums[i];
        if (nums[l] + nums[r] > target) {
          r--;
        } else if (nums[l] + nums[r] < target){
          l++;
        } else {
          List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r]);
          if (!seen.contains(list)) {
            seen.add(list);
            result.add(list);
          }
          l++;
          r--;
        }
      }
    }

    return result;
  }
}
