package tries;

public class TrieNodeData {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd;
    }

    boolean search(String key, TrieNode root) {
         TrieNode cur = root;
         for (int i = 0; i < key.length(); i++) {
             int index  = key.charAt(i) - 'a';
             if (cur.child[index] == null) {
                 return false;
             }
             cur = cur.child[index];
         }
         return cur.isEnd;
     }

    void insert(String key, TrieNode root) {
        TrieNode cur = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (cur.child[index] == null) {
                cur.child[index] = new TrieNode();
            }
            cur = cur.child[index];
        }
        cur.isEnd = true;
    }
}

