package string.gfg;

public class AsciiCharecter {
    public static void main(String[] args) {
        int c = 'a';
        //System.out.println("a -> " + c);
        c = 'z';
        //System.out.println("z -> " + c);
        c = 'A';
        //System.out.println("A -> " + c);
        c = 'Z';
        //System.out.println("Z -> " + c);

        String str = "geeksforgeeks";
        int[] count = new int[26];

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0)
                System.out.println((char)(i+'a') + " -> " + count[i]);
        }

    }
}
