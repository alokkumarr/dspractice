package string;

public class Anagram {
  public static void main(String[] args) {
    System.out.println(checkAnagram("alok1", "alok1"));
  }

  private static boolean checkAnagram(String str1, String str2) {

    if (str1.length() != str2.length()) {
      return false;
    }

    boolean[] visited = new boolean[str2.length()];
    boolean isAnagram = false;
    for (int i = 0; i < str1.length(); i++) {
      char c = str1.charAt(i);
      isAnagram = false;
      for (int j = 0; j < str2.length(); j++) {
        if (str2.charAt(j) == c && !visited[j]) {
          isAnagram = true;
          visited[j] = true;
          break;
        }
      }
      if (!isAnagram) break;
    }


    return isAnagram;
  }
}
