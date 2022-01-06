package leetcode;

public class WordDictionary {

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        insert(word, root, 0);
    }

    public boolean search(String word) {
        return search(word, root, 0);
    }

    private boolean search(String pat, Node x, int d) {
        if (x == null) return false;
        if (d == pat.length()) return x.isEnd;
        char next = pat.charAt(d);
        boolean ans = false;
        for (char c = 0; c < 26; c++)
            if (next == '.' || c == next - 'a')
                ans = ans || search(pat, x.children[c], d + 1);
        return ans;
    }

    private Node insert(String word, Node x, int d) {
        if (x == null) x = new Node();
        if (d == word.length()) {
            x.isEnd = true; return x;
        }
        char c = word.charAt(d);
        x.children[c - 'a'] = insert(word, x.children[c - 'a'], d + 1);
        return x;
    }

    private static class Node {
        private Node[] children = new Node[26];
        boolean isEnd = false;
    }
}
