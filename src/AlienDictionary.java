import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
There is a new alien language which uses the latin alphabet. However, the order among 
letters are unknown to you. You receive a list of non-empty words from the dictionary, 
where words are sorted lexicographically by the rules of this new language. Derive the 
order of letters in this language.

Example 1:
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".

Example 2:
Given the following words in dictionary,

[
  "z",
  "x"
]
The correct order is: "zx".

Example 3:
Given the following words in dictionary,

[
  "z",
  "x",
  "z"
]
The order is invalid, so return "".

Note:
You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
 */

public class AlienDictionary {
	public String alienOrder(String[] words) {
		// each character and their parents
		HashMap<Character, HashSet<Character>> map = new HashMap<>();
		// topological level, how many parent
		HashMap<Character, Integer> degree = new HashMap<>();
		for (String s : words) {
			for (char c : s.toCharArray()) {
				degree.put(c, 0);
			}
		}
		// create topological graph
		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];
			for (int j = 0; j < word1.length() && j < word2.length(); j++) {
				char char1 = word1.charAt(j);
				char char2 = word2.charAt(j);
				if (char1 != char2) {
					if (!map.containsKey(char1)) {
						// if doesn't contain the child
						HashSet<Character> set = new HashSet<>();
						map.put(char1, set);
					}
					HashSet<Character> set = map.get(char1);
					if (!set.contains(char2)) {
						// if the child doesn't have the parent
						set.add(char2);
						degree.put(char2, degree.get(char2) + 1);
					}
					break;// no need to loop more
				}
				if (j == word2.length() - 1 && word1.length() > word2.length()) {
					return ""; // wrtkj, wrt not allowed, invalid order.
				}
			}
		}
		// topological sort
		StringBuffer result = new StringBuffer();
		Queue<Character> queue = new LinkedList<>();
		// initiate queue
		for (char c : degree.keySet()) {
			if (degree.get(c) == 0)
				// find degree 0
				queue.offer(c);
		}
		while (!queue.isEmpty()) {
			char c = queue.poll();
			result.append(c);
			if (map.containsKey(c)) {
				for (char c2 : map.get(c)) {
					degree.put(c2, degree.get(c2) - 1);
					if (degree.get(c2) == 0)
						queue.add(c2);
					// always add degree 0 to the queue to prune;
				}
			}
		}
		if (result.length() != degree.size())
			return "";
		// if has isolated nodes, or loop, size would be different.
		return result.toString();
	}

	public static void main(String[] args) {
		AlienDictionary s = new AlienDictionary();
		System.out.println("1: " + s.alienOrder(new String[] { "srtkj", "srt" }));
		System.out.println("2: " + s.alienOrder(new String[] { "xy", "xz" }));
	}
}