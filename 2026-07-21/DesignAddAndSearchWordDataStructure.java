public class DesignAddAndSearchWordDataStructure {
  class WordDictionary {

    class TrieNode {
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
        if (current.children[c - 'a'] == null)
          current.children[c - 'a'] = new TrieNode();
        current = current.children[c - 'a'];
      }

      // Make this a word
      current.isEnd = true;
    }

    public boolean search(String word) {
      return searchHelper(root, word, 0);
    }

    private boolean searchHelper(TrieNode node, String word, int index) {
      if (node == null)
        return false;
      if (index == word.length())
        return node.isEnd;

      char c = word.charAt(index);

      if (c != '.') {
        return searchHelper(node.children[c - 'a'], word, index + 1);
      }

      for (TrieNode child : node.children) {
        if (searchHelper(child, word, index + 1))
          return true;
      }

      return false;
    }
  }
}
