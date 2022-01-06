package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;

        permuteRecur(nums, ans, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }

    private void permuteRecur(int[] nums, List<List<Integer>> ans, List<Integer> currResult, boolean[] used) {
        if (currResult.size() == nums.length) {
            ans.add(new ArrayList<>(currResult));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;

            currResult.add(nums[i]);
            used[i] = true;
            permuteRecur(nums, ans, currResult, used);
            used[i] = false;
            currResult.remove(currResult.size() - 1);
        }
    }
}
