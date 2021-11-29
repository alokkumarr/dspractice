package string;

public class CountFrequencyInSortedOrder {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        printFrequency(str);
    }

    /*
       count frequency in sorted order, here will use the ascii logic
       As ascii represent a-z with 97-122 and A-Z with 65-90
     */
    private static void printFrequency(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length();i++){
            char ch = str.charAt(i);
            count[ch - 'a']++;
        }
        for (int i = 0; i<count.length;i++) {
            if (count[i] > 0) {
                System.out.println((char)(i+'a') + " -> " + count[i]);
            }
        }
    }
}
