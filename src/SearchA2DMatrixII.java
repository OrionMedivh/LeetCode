public class SearchA2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null)
			return false;
		int ver = matrix.length;
		int hor = matrix[0].length;
		int i = 0, j = hor - 1; // search from a corner, the path will look like
								// a saw, or 'Z', O(m+n) time
		while (i < ver && j >= 0) {
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