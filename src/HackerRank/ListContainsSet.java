package HackerRank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListContainsSet {

  public static void main(String[] args) {

    Set<String> ecChoiceCodes = new HashSet<>();
    ecChoiceCodes.add("A");
    ecChoiceCodes.add("B");
    ecChoiceCodes.add("C");
    ecChoiceCodes.add("D");
    ecChoiceCodes.add("E");

    List<String> choiceCodes = new ArrayList<>();
    choiceCodes.add("A");
    choiceCodes.add("B");

    if (!ecChoiceCodes.isEmpty() && !choiceCodes.containsAll(ecChoiceCodes)) {
      choiceCodes.addAll(ecChoiceCodes);
    }

    System.out.println(choiceCodes);

  }
}
