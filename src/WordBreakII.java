import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	// DFS with memorization
	HashMap<String, List<String>> map;
	HashSet<String> set;

	public List<String> wordBreak(String s, List<String> wordDict) {
		map = new HashMap<String, List<String>>();
		set = new HashSet<>();
		for (String word : wordDict) {
			set.add(word);
		}
		return wordBreak(s, set);
	}

	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> res = new ArrayList<String>();
		if (s == null || s.isEmpty()) {
			return res;
		}
		if (map.containsKey(s)) {
			return map.get(s);
		}
		if (wordDict.contains(s)) {
			res.add(s);
		}
		for (int i = 1; i < s.length(); i++) {
			String word = s.substring(i);
			if (wordDict.contains(word)) {
				List<String> sublist = wordBreak(s.substring(0, i), wordDict);
				if (sublist.size() != 0) {
					for (String substring : sublist) {
						res.add(substring + " " + word);
					}
				}
			}
		}
		map.put(s, res);
		return res;
	}
}
