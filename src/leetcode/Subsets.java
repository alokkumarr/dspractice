package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(subsets(arr));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList(), list);
        return list;
    }

    public static void backtrack(int[] nums, int start, List<Integer> tempList, List<List<Integer>> list) {
        // add temp list to result
        list.add(new ArrayList<>(tempList));

        // start the loop for evry element
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(nums, i + 1, tempList, list);
            tempList.remove(tempList.size() - 1);
        }
    }
}
