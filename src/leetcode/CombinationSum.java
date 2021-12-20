package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTracking(candidates, 0, target, list, result);
        return result;
    }

    private void backTracking(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> result) {
        if (target < 0) return;
        if (target == 0) {
            result.add(list);
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            backTracking(candidates, i, target - candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }

}
