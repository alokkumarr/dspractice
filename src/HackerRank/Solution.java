package HackerRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String digitString = scanner.next();

    int[] digits = digitString.chars().map(c -> c - '0').toArray();
    int validNoPalindrome = 0;

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < digits.length; ++i) {
      int item = digits[i];
      if (map.containsKey(item)) {
        map.put(item, map.get(item) + 1);
      } else {
        map.put(item, 1);
      }
    }

    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      if (e.getValue() == 2) {
        validNoPalindrome = validNoPalindrome + 1;
      }
    }

    System.out.println(validNoPalindrome*2);

    scanner.close();
  }
}
