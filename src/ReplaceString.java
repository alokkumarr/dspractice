public class ReplaceString {

  public static void main(String[] args) {
    String test = "<Product_Name> ,<External_Order_Number>";
    String placeHolders[] = test != null ? test.split(",") : null;

    for (String placeHolder : placeHolders) {
      placeHolder = placeHolder.replaceAll("[\\<\\>]", "");
      System.out.println(placeHolder);
    }
  }
}
