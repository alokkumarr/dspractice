package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    private Map<String, Boolean> hmap = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s)) return true;
        if (hmap.containsKey(s)) return hmap.get(s);

        for(int i=0;i<s.length();i++) {
            String prefix = s.substring(0,i+1);
            String suffix = s.substring(i+1);

            if(wordDict.contains(prefix) && wordBreak(suffix, wordDict)) {
                hmap.put(s, true);
                return true;
            }
        }
        hmap.put(s, false);
        return false;
    }

}
