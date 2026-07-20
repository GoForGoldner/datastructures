public class DesignWordSearchDataStructure {
  class WordDictionary {

    private static class TrieNode {
      TrieNode[] children = new TrieNode[26];
      boolean isEnd = false;
    }

    private TrieNode root;

    public WordDictionary() {
      root = new TrieNode();
    }

    public void addWord(String word) {
      TrieNode current = root;
      for (char c : word.toCharArray()) {
        int i = c - 'a';
        if (current.children[i] == null) {
          current.children[i] = new TrieNode();
        }
        current = current.children[i];
      }

      current.isEnd = true;
    }

    public boolean search(String word) {
      return searchHelper(root, 0, word);
    }

    private boolean searchHelper(TrieNode node, int index, String word) {
      if (node == null)
        return false;
      if (index == word.length()) {
        return node.isEnd;
      }

      char c = word.charAt(index);
      int i = c - 'a';

      if (c == '.') {
        for (TrieNode child : node.children) {
          if (child != null && searchHelper(child, index + 1, word))
            return true;
        }
      } else {
        if (node.children[i] == null)
          return false;
        else
          return searchHelper(node.children[i], index + 1, word);
      }

      return false;
    }
  }
}
