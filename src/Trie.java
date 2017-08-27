class TrieNode {
	char c;
	TrieNode[] children;
	boolean isWord;

	public TrieNode(char c) {
		this.c = c;
		children = new TrieNode[26];
		isWord = false;
	}
}

public class Trie {
	private TrieNode root;
	private TrieNode cur;

	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode(' ');
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		cur = root;
		for (char c : word.toCharArray()) {
			if (cur.children[c - 'a'] == null) {
				cur.children[c - 'a'] = new TrieNode(c);
			}
			cur = cur.children[c - 'a'];
		}
		cur.isWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		return startsWith(word) && cur.isWord == true;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		cur = root;
		for (char c : prefix.toCharArray()) {
			if (cur == null)
				return false;
			cur = cur.children[c - 'a'];
		}
		return cur != null;
	}
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */