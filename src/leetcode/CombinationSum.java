package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTracking(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }


    private void backTracking(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> result) {
        if (target < 0) return;
        if (target == 0) {
            result.add(list);
        }

        // iterate every element of arr
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]); // add element to list and add minus from target
            backTracking(candidates, i, target - candidates[i], list, result);
            // while backtracking remove from list
            list.remove(list.size() - 1);
        }
    }

}
