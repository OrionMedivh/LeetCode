
public class MaximumSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return 0;
		}
		int m = matrix.length, n = matrix[0].length;
		int[] dp = new int[m + 1];
		int max = 0;
		int prev = 0; // store dp[i-1][j-1];
		for (int j = 0; j < n; j++) {
			for (int i = 1; i <= m; i++) {
				int temp = dp[i];
				if (matrix[i - 1][j] == '1') {
					dp[i] = Math.min(Math.min(dp[i - 1], dp[i]), prev) + 1;
					max = Math.max(max, dp[i]);
				} else {
					dp[i] = 0;
				}
				prev = temp;
			}
		}
		return max * max;
	}
}
