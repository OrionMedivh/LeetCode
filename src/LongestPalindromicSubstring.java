
public class LongestPalindromicSubstring {
	private int min, max;

	public String longestPalindrome(String s) {
		if (s.length() < 2)
			return s;
		min = 0;
		max = 0;
		for (int i = 0; i < s.length(); i++) {
			extendPalindrome(s, i, i);
			extendPalindrome(s, i, i + 1);
		}
		return s.substring(min, max + 1);
	}

	public void extendPalindrome(String s, int i, int j) {
		while (i >= 0 && j < s.length() && (s.charAt(i) == s.charAt(j))) {
			i--;
			j++;
		}
		if (max - min < j - i - 1) {
			min = i + 1;
			max = j - 1;
		}
	}
}
