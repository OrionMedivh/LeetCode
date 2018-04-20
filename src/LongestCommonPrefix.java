
/*
Write a function to find the longest common prefix string amongst an array of strings.
 */

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		// corner cases first
		if (strs.length == 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		int index = 0;
		// iterate through characters in the first string
		for (char c : strs[0].toCharArray()) {
			// for each of the string in the array
			for (String s : strs) {
				// if index exceeds the length of current string
				// or the character at current index doesn't match
				if (index >= s.length() || s.charAt(index) != c) {
					return sb.toString();
				}
			}
			// Till here, all characters at current index are the same
			// append the character to string
			sb.append(c);
			// increase index
			index++;
		}
		return sb.toString();
	}
}
