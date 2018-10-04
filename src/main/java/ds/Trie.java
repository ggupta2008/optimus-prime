package ds;

import java.util.HashMap;

public class Trie {
    private TrieNode root = new TrieNode();

    public TrieNode getRoot() {
        return root;
    }

    public void setRoot(TrieNode root) {
        this.root = root;
    }

    private void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            current = current.getChildren().computeIfAbsent(c, k -> new TrieNode());
        }
        current.setWord(true);
    }

    private boolean findWord(String word) {
        TrieNode current = root;
        boolean result = true;
        for (int i = 0; i < word.length(); i++) {
            if (current.getChildren().get(word.charAt(i)) == null) {
                result = false;
                break;
            } else {
                current = current.getChildren().get(word.charAt(i));
            }
        }

        return current.isWord && result;
    }

    private void delete(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.getChildren().get(c) == null) {
                current = null;
                break;
            }
            current = current.getChildren().get(c);
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("Gaurav");
        trie.insert("Gupta");
        trie.delete("Gaurav");
    }

    private class TrieNode {
        private HashMap<Character, TrieNode> children = new HashMap<>();
        private boolean isWord;

        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }

        public void setChildren(HashMap<Character, TrieNode> children) {
            this.children = children;
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }
    }
}
