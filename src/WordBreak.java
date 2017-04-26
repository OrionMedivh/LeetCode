import java.util.HashSet;
import java.util.List;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		HashSet<String> set = new HashSet<String>();
		for (String w : wordDict) {
			set.add(w);
		}
		int length = s.length();
		boolean[] strmap = new boolean[length + 1]; // + 1 for whole word
		strmap[0] = true; // empty string is true;
		for (int i = 1; i <= length; i++) {
			for (int j = 0; j < i; j++) {
				if (strmap[j] && set.contains(s.substring(j, i))) {
					strmap[i] = true;
					break;
				}
			}
		}
		return strmap[length];
	}
}
