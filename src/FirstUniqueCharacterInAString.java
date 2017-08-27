
/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 */

public class FirstUniqueCharacterInAString {

	public int firstUniqChar(String s) {
		int[] freq = new int[26];
		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (freq[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}

	public int firstUniqCharBrutalForce(String s) {
		boolean[] duplicated = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (duplicated[i] == true) {
				continue;
			}
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					duplicated[i] = true;
					duplicated[j] = true;
				}
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (duplicated[i] == false) {
				return i;
			}
		}
		return -1;
	}
}
