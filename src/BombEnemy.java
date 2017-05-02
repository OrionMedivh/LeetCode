
public class BombEnemy {
	public int maxKilledEnemies(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int max = 0;
		int row = 0;
		// since we iterate by row first, so no need to use an array to save it
		int[] col = new int[grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 'W') {
					continue;
				}
				if (j == 0 || grid[i][j - 1] == 'W') {
					// only calculate row if it's new row or right side of a
					// wall
					row = killedEnemiesRow(grid, i, j);
				}
				if (i == 0 || grid[i - 1][j] == 'W') {
					// only calculate column if it's new column or down side of
					// a wall
					col[j] = killedEnemiesCol(grid, i, j);
				}
				if (grid[i][j] == '0') {
					max = Math.max(row + col[j], max);
				}
			}
		}
		return max;
	}

	// calculate killed enemies for row i from column j
	private int killedEnemiesRow(char[][] grid, int i, int j) {
		int num = 0;
		while (j < grid[0].length && grid[i][j] != 'W') {
			if (grid[i][j] == 'E') {
				num++;
			}
			j++;
		}
		return num;
	}

	private int killedEnemiesCol(char[][] grid, int i, int j) {
		int num = 0;
		while (i < grid.length && grid[i][j] != 'W') {
			if (grid[i][j] == 'E') {
				num++;
			}
			i++;
		}
		return num;
	}
}
