package string.gfg;

public class CheckForRoatation {
    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "DCAB";

        // if string one or s2 rotate by clockwise or anticlockwise to build another string
        boolean isRatation = isRotation(s1, s2);
        System.out.println(isRatation);
    }

    private static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String temp = s1 + s1;
        return temp.indexOf(s2) > 0;
    }

    /**
     *  if (s1.length() != s2.length()) {
     *             return false;
     *         }
     *         String temp = s1 + s1;
     *         return temp.indexOf(s2) != -1;
     */
}
