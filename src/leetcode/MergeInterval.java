package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        // sorted base upon the starting point
        //Arrays.sort(intervals, (a, b) ->  Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (list.size() == 0) {
                list.add(interval);
            } else {
                int[] prevInterval = list.get(list.size() - 1);
                if (interval[0] < prevInterval[1]) {
                    prevInterval[1] = Math.max(interval[1], prevInterval[1]);
                } else {
                    list.add(interval);
                }
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
