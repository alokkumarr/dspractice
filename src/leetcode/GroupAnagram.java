package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> bmap = new HashMap<>();

        for (String str : strs) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            if (!bmap.containsKey(map)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                bmap.put(map, list);
            } else {
                List<String> list = bmap.get(map);
                list.add(str);
            }
        }

        List<List<String>> list = new ArrayList<>();
        list.addAll(bmap.values());

        return list;
    }
}
