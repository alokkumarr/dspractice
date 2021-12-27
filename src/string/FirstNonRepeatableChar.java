package string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatableChar {

    char firstNonRepeating(String stream) {
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < stream.length(); i++) {
            char ch = stream.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.get(ch) == 1) {
                queue.add(ch);
            }

            while (!queue.isEmpty()) {
                char temp = queue.peek();
                if (map.get(temp) == 1)
                    break;
                else
                    queue.remove(temp);
            }
        }
        if (queue.isEmpty())
            return ' ';
        else
            return queue.peek();
    }
}
