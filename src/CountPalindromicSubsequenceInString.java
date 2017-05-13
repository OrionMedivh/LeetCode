public class CountPalindromicSubsequenceInString {
	public int countPalindromicSubsequenceInString(String str) {
		int n = str.length();
		int[][] res = new int[n + 1][n + 1];
		// count of palindromes from i to j
		for (int i = 0; i < n; i++) {
			res[i][i] = 1;
		}
		for (int i = 2; i <= n; i++) { // size, from 2 to n
			for (int j = 0; j <= n - i; j++) { // start index, from 0 to n - i
				int k = i + j - 1; // end index
				res[j][k] = res[j][k - 1] + res[j + 1][k] - res[j + 1][k - 1];
				if (str.charAt(j) == str.charAt(k)) {
					res[j][k]++;
				}
			}
		}
		return res[0][n - 1];
	}
}
