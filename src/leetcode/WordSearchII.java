package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordSearchII {

    class TrieNode {
        public boolean isWord = false;
        TrieNode[] children = new TrieNode[26];

    }

    TrieNode root = new TrieNode();
    boolean[][] flag;
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        flag = new boolean[board.length][board[0].length];

        addToTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    search(board, i, j, root, "", result);
                }
            }
        }

        return new LinkedList<>(result);
    }

    private void search(char[][] board, int i, int j, TrieNode node, String word, Set<String> result) {
        if (i > board.length || i < 0 || j > board[i].length || j < 0
                || flag[i][j] || node.children[board[i][j] - 'a'] == null) {
            return;
        }

        flag[i][j] = true;
        node = node.children[board[i][j] - 'a'];
        if (node.isWord)
            result.add(word + board[i][j]);

        search(board, i + 1, j, node, word + board[i][j], result);
        search(board, i - 1, j, node, word + board[i][j], result);
        search(board, i, j + 1, node, word + board[i][j], result);
        search(board, i, j - 1, node, word + board[i][j], result);

        flag[i][j] = false;
    }

    private void addToTrie(String[] words) {
        for (String word : words) {
            TrieNode node  = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.children[ch - 'a'] == null){
                    node.children[ch - 'a'] = new TrieNode();
               }
               node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }
    }
}
