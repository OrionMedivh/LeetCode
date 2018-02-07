import java.util.HashMap;

public class LongestSubstringWithoutReapeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		// keep a sliding window
		int longest = 0;
		int head = 0, tail = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		while (tail < s.length()) {
			char cur = s.charAt(tail);
			if (map.containsKey(cur)) {
				head = Math.max(head, map.get(cur) + 1);
				// get the position of last occurrence.
				// substring starts from next character.
				// max is for the case that last occurrence
				// is less than the position of head.
			}
			map.put(cur, tail);
			longest = Math.max(longest, tail - head + 1);
			tail++;
		}
		return longest;
	}
}
