import java.util.HashMap;
import java.util.HashSet;

/*
Given a string, find the length of the longest substring without 

repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that 

the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LongestSubstringWithoutRepeatingCharacters {
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

	public int lengthOfLongestSubstring2(String s) {
		// keep a sliding window
		int longest = 0;
		int head = 0, tail = 0;
		HashSet<Character> set = new HashSet<>();
		while (tail < s.length()) {
			while (set.contains(s.charAt(tail))) {
				// until removed the duplicate character
				set.remove(s.charAt(head));
				head++;
			}
			set.add(s.charAt(tail));
			longest = Math.max(longest, tail - head + 1);
			tail++;
		}
		return longest;
	}
	// Since both pointers will traverse at most a string length,
	// so it's O(2n) = O(n),
	// but still it's not the best approach.

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(s.lengthOfLongestSubstring("abba"));
	}
}
