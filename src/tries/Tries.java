package tries;

import java.util.HashMap;

public class Tries {

    private Node root;

    // initialize the data structure
    Tries() {
        root = new Node('\0');
    }

    // insert a word into the tries
    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new Node(ch);
                curr = curr.children[ch - 'a'];
            }
            curr.isWord = true;
        }
    }

    // search if a word into the tries
    public boolean search(String word) {
        Node node = getNode(word);
        return node != null && node.isWord;
    }

    // return if a word into the tries start with the word
    public boolean startWith(String prefix) {
        return  getNode(prefix) != null;
    }

    private Node getNode(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                return null;
            }
            curr = curr.children[c - 'a'];
        }
        return curr;
    }

    class Node {
        public char c;
        public boolean isWord;
        public Node[] children;

        Node(char c) {
            this.c = c;
            isWord = false;
            children = new Node[26];
        }
    }

}