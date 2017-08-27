public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		if (grid == null) {
			return 0;
		}
		int m = grid.length;
		if (m == 0) {
			return 0;
		}
		int n = grid[0].length;
		if (n == 0) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					count++;
					traverse(i, j, m, n, grid);
				}
			}
		}
		return count;
	}

	private void traverse(int i, int j, int m, int n, char[][] grid) {
		if (i < 0 || i == m) {
			return;
		}
		if (j < 0 || j == n) {
			return;
		}
		if (grid[i][j] == '1') {
			grid[i][j] = '0';
			int[] directions = new int[] { -1, 0, 1, 0, -1 };
			for (int k = 0; k < 4; k++) {
				traverse(i + directions[k], j + directions[k + 1], m, n, grid);
			}
		}
	}
}