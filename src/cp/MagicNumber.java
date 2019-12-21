package cp;

public class MagicNumber {
  public static void main(String[] args) {
    System.out.println(magicRec(12345));
  }

  private static int magicNo(int number) {
    int sum = 0;
    while (number > 0 || sum > 9) {
      if (number == 0) {
        number = sum;
        sum = 0;
      }
      sum += number % 10;
      number /= 10;
    }
    return sum;
  }

  static int magicRec(int n){
    if (n == 0) return 0;
    return (n % 9 == 0) ? 9 : n % 9;
  }
}
