
// find if there's a sub matrix whose sum equals k

public class SubMatrixSumEqualsK {
	public boolean subMatrixSum(int[][] nums, int k) {
		if (nums == null || nums.length == 0 || nums[0] == null || nums[0].length == 0) {
			return false;
		}
		int m = nums.length;
		int n = nums[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				nums[i][j] += nums[i][j - 1];
			}
		}
		for (int j = 0; j < n; j++) {
			for (int i = 1; i < m; i++) {
				nums[i][j] += nums[i - 1][j];
			}
		}
		for (int x1 = 0; x1 < m; x1++) {
			for (int y1 = 0; y1 < n; y1++) {
				for (int x2 = 0; x2 < x1; x2++) {
					for (int y2 = 0; y2 < y1; y2++) {
						if (nums[x1][y1] + nums[x2][y2] - nums[x1][y2] - nums[x2][y1] == k) {
							return true;
							// 1 2 3 => 1 3 6
							// 4 5 6 => 5 12 21 => 5 == 1+12-3-5
							// 7 8 9 => 12 27 45
						}
					}
				}
			}
		}
		return false;
	}
}
