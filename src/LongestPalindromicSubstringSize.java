
public class LongestPalindromicSubstringSize {
	public int LongestPalindromeSize(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		return lcs.longestCommonSubsequence(s, new StringBuffer(s).reverse().toString());
	}
}
