package reccursion;

public class StringPermutation {
    public static void main(String[] args) {
        String s1 = "ABC";
        permute(s1, 0, s1.length()-1);
    }

    static private void permute(String str, int l, int r) {
        if (l == r)
            System.out.print(str + ",");
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    static String swap(String str, int l, int r) {
        char[] chars = str.toCharArray();
        char tmp = chars[l];
        chars[l] = chars[r];
        chars[r] = tmp;
        return String.valueOf(chars);
    }
}
