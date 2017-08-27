public class SearchA2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null)
			return false;
		int m = matrix.length;
		int n = matrix[0].length;
		int i = 0, j = n - 1;
		// search from a corner, the path will look like
		// a saw, or 'Z', O(m+n) time
		while (i < m && j >= 0) {
			if (matrix[i][j] == target)
				return true;
			if (matrix[i][j] < target) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}
}