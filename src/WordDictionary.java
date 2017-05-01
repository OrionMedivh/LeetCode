public class WordDictionary {
	public class TrieNode {
		public TrieNode[] children = new TrieNode[26];
		public boolean isWord;
	}

	private TrieNode root, node;

	/** Initialize your data structure here. */
	public WordDictionary() {
		root = new TrieNode();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		node = root;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TrieNode();
			}
			node = node.children[c - 'a'];
		}
		node.isWord = true;
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the
	 * dot character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		return search(word.toCharArray(), 0, root);
	}

	private boolean search(char[] chs, int index, TrieNode node) {
		if (index == chs.length) {
			return node.isWord;
		}
		if (chs[index] == '.') {
			for (int i = 0; i < node.children.length; i++) {
				if (node.children[i] != null && search(chs, index + 1, node.children[i])) {
					return true;
				}
			}
		} else {
			return node.children[chs[index] - 'a'] != null && search(chs, index + 1, node.children[chs[index] - 'a']);
		}
		return false;
	}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 */