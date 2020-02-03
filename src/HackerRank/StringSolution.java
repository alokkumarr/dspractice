package HackerRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringSolution {

  public static void main(String[] args) {
    System.out.println(compress("baac", 2));
  }


  public static String compress(String str, int k) {
    String output = null;
    int len = str.length();
    for (int i = 0; i < len - 1; i++) {
      int count = 1;
      while (str.charAt(i) == str.charAt(i + 1)) {
        i++;
        count++;
        if (count == k) {
          output = str.substring(0, i - k + 1) + str.substring(i + 1, len);
          break;
        }
        if (i + 1 == str.length())
          break;
      }
    }
    return output != null ? compress(output, k) : str;
  }


  private static String compressSubstring(String word, int k) {
    System.out.println(word);
    HashMap<Character, Integer> m = new HashMap<>();
    for (int i = 0; i < word.length() - 1; i++) {
      if (m.containsKey(word.charAt(i)) && word.charAt(i) == word.charAt(i + 1)) {
        m.put(word.charAt(i), m.get(word.charAt(i)) + 1);
      } else {
        m.put(word.charAt(i), 1);
      }
    }

    System.out.println(m);
    Set<Map.Entry<Character, Integer>> map = m.entrySet();
    for (Map.Entry<Character, Integer> entry : map) {
      if (entry.getValue() >= k) {
        word = subString(word, entry.getKey(), k);
        // System.out.println(word);
      }
    }
    return word;
  }


  public static String subString(String str, Character c, int k) {
    int count = 0;
    for (int i = 0; i <= str.length() - 1; i++) {
      if (c.equals(str.charAt(i))) {
        count++;
        if (k >= count) {
          str = str.substring(0, i) + str.substring(i + 1);
          --i;
        }
      }
    }
    return str;
  }

  private static HashMap<Character, Integer> countCharacters(String s) {

    HashMap<Character, Integer> characterCount = new HashMap<Character, Integer>();
    char[] characterArray = s.toCharArray();

    for (Character c : characterArray) {
      int newCount;
      Integer count = characterCount.get(c);
      if (count == null) {
        newCount = 1;
      } else {
        newCount = count + 1;
      }
      characterCount.put(c, newCount);
    }

    return characterCount;
  }


  static final int MAX_CHARS = 256;

  public static int shortestSubstring(String str) {
    // Write your code here
    int n = str.length();
    int distCount = 0;

    boolean[] visited = new boolean[MAX_CHARS];
    Arrays.fill(visited, false);
    for (int i = 0; i < n; i++) {
      if (visited[str.charAt(i)] == false) {
        visited[str.charAt(i)] = true;
        distCount++;
      }
    }

    int start = 0, start_index = -1;
    int min_len = Integer.MAX_VALUE;

    int count = 0;
    int[] curr_count = new int[MAX_CHARS];
    for (int j = 0; j < n; j++) {
      curr_count[str.charAt(j)]++;

      if (curr_count[str.charAt(j)] == 1)
        count++;

      if (count == distCount) {
        while (curr_count[str.charAt(start)] > 1) {
          if (curr_count[str.charAt(start)] > 1)
            curr_count[str.charAt(start)]--;
          start++;
        }

        int len_window = j - start + 1;
        if (min_len > len_window) {
          min_len = len_window;
          start_index = start;
        }
      }
    }
    return str.substring(start_index, start_index + min_len).length();

  }
}
