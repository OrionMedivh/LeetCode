import java.util.Arrays;

//https://leetcode.com/problems/maximal-rectangle/#/solutions

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int max = 0;
		int[] height = new int[n];
		int[] left = new int[n];
		int[] right = new int[n];
		Arrays.fill(right, n);
		for (int i = 0; i < m; i++) {
			int currLeftBound = 0;
			int currRightBound = n;

			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					height[j]++;
				} else {
					height[j] = 0;
				}
			}
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					left[j] = Math.max(left[j], currLeftBound);
				} else {
					left[j] = 0;
					currLeftBound = j + 1;
				}
			}

			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					right[j] = Math.min(right[j], currRightBound);
				} else {
					right[j] = n;
					currRightBound = j;
				}
			}
			for (int j = 0; j < n; j++) {
				max = Math.max(max, (right[j] - left[j]) * height[j]);
			}
		}
		return max;
	}
}
