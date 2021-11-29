package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FindMinOfSubArrayK {

    public static void main(String[] args) {

    }

    public List<Integer> maxSlidingWindow(List<Integer> arr, int k) {
        int n = arr.size(), j = 0;
        List<Integer> res = new ArrayList<>();
        TreeMap<Integer, Integer> bst = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            // add every element in tree
            bst.put(arr.get(i), bst.getOrDefault(arr.get(i), 0) + 1);

            if (i + 1 >= k) {
                res.add(bst.firstKey()); // return max element in BST
                removeElement(bst, arr.get(i+1-k));
            }
        }
        return res;
    }

    static void removeElement(TreeMap<Integer, Integer> bst, int x) {
        bst.put(x, bst.getOrDefault(x, 0) - 1);
        if (bst.get(x) == 0) bst.remove(x);
    }
}
