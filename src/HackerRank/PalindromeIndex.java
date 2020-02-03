package HackerRank;

public class PalindromeIndex {

  static int palindromeIndex1(String str) {

    int len = str.length();
    for (int i = 0; i > len/2; i ++){

      if (str.charAt(i) != str.charAt(len-i-1)){
        boolean haveValidPalindrome = havevalidPalindrome(str.substring(i+1, len-i-1));
        if (haveValidPalindrome) {
          return i;
        }
        return len-i-1;
      }
    }
    return -1;
  }

  private static boolean havevalidPalindrome(String substring) {
    int len = substring.length();
    for (int i = 0; i < len/2; i ++){
      if (substring.charAt(i) != substring.charAt(len-i-1)){
        return false;
      }
    }
    return true;
  }


  static int palindromeIndex(String s){
    for(int i =0,j =s.length()-1; i<j; i++, j--)
      if(s.charAt(i)!=s.charAt(j))
        if(isPalindrome(s, i))
          return i;
        else if(isPalindrome(s, j))
          return j;
    return -1;
  }

  static boolean isPalindrome(String s, int index){
    for(int i =index+1,j =s.length()-1-index; i<j; i++, j--)
      if(s.charAt(i)!=s.charAt(j))
        return false;
    return true;
  }

  public static void main(String[] args) {
    System.out.println(palindromeIndex("abca"));
  }

}
