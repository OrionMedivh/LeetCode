import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

public class FindAllAnagramsInAString {
	// each time compare whole string
	public List<Integer> findAnagrams(String s, String p) {
		int size1 = s.length();
		int size2 = p.length();
		List<Integer> list = new ArrayList<>();

		// corner case:
		if (size1 < size2) {
			return list;
		}

		int[] array1 = new int[26];
		for (char c : p.toCharArray()) {
			array1[c - 'a']++;
		}

		for (int i = 0; i < size1 - size2 + 1; i++) {
			int[] array2 = new int[26];
			for (char c : s.substring(i, i + size2).toCharArray()) {
				array2[c - 'a']++;
			}
			if (Arrays.equals(array1, array2)) {
				list.add(i);
			}
		}
		return list;
	}

	// sliding window

}
