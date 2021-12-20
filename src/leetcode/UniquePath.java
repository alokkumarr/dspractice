package leetcode;

import java.util.HashMap;
import java.util.Map;

public class UniquePath {

    public int uniquePaths(int m, int n) {
        Map<String, Integer> hm = new HashMap<>(); 
        int path = findPathMemo(0,0,m-1,n-1, hm);
        return path;
    }

    private int findPathMemo(int si, int sj, int ei, int ej, Map<String, Integer> hm) {
        if (si == ei && sj == ej) return 1;
        if (si > ei || sj > ej) return 0;

        String key = si + "#" + sj;
        if (hm.containsKey(key))
            return hm.get(key);

        int opt1 = findPathMemo(si + 1, sj, ei, ej, hm);
        int opt2 = findPathMemo(si, sj + 1, ei, ej, hm);

        hm.put(key, opt1 + opt2);
        return opt1+opt2;
    }


    public int uniquePaths1(int m, int n) {
        int path = findPath(0,0,m-1,n-1);
        return path;
    }

    private int findPath(int si, int sj, int ei, int ej) {
        if (si == ei && sj == ej) return 1;
        if (si > ei || sj > ej) return 0;

        int opt1 = findPath(si+1, sj, ei, ej);
        int opt2 = findPath(si, sj+1, ei, ej);
        return opt1 + opt2;
    }
}
