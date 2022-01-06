package leetcode;

public class Trie {
    private Node root;

    public Trie() {
        root = new Node('\0');
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new Node(ch);
            curr = curr.children[ch - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node node  = getNode(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    private Node getNode(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch - 'a'] == null) return null;
            curr = curr.children[ch - 'a'];
        }
        return curr;
    }


    class Node {
        public char c;
        public boolean isWord;
        public Node[] children;

        public Node(char c) {
            this.c = c;
            isWord = false;
            children = new Node[26];
        }
    }
}
