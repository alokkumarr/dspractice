import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoinerClass {

  public static void main(String[] args) {
    String tempReason = "EUCC Timeout;EUCC Timeout;EUCC Timeout;PLAB Timeout";
    String newS = "EUCC1 Timeout";

    System.out.println(tempReason.contains(newS));
  }
}
