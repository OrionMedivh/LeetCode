
public class ImplementStrStr {
	public int strStr(String haystack, String needle) {
		if (needle.length() > haystack.length()) {
			return -1;
		}
		int i = 0, j = 0, index = 0;
		while (i < haystack.length() && j < needle.length()) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else {
				i = ++index;
				j = 0;
			}
		}
		if (j == needle.length()) {
			return index;
		} else {
			return -1;
		}
	}
}
