import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsII {
	private int count;
	private int m;
	private int n;

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		List<Integer> result = new ArrayList<Integer>();
		count = 0;
		this.m = m;
		this.n = n;
		if (m == 0 || n == 0) {
			return result;
		}
		int[][] grid = new int[m][n];
		for(int[] row:grid)
		Arrays.fill(row, -2);
		for (int[] position : positions) {
			grid[position[0]][position[1]] = -1;
			count++;
			traverse(grid, position[0], position[1]);
			result.add(count);
		}
		return result;
	}

	private void traverse(int[][] grid, int i, int j) {
		if (i > 0 && grid[i - 1][j] != -2)
			union(grid, i, j, i - 1, j);
		if (i < m - 1 && grid[i + 1][j] != -2)
			union(grid, i, j, i + 1, j);
		if (j > 0 && grid[i][j - 1] != -2)
			union(grid, i, j, i, j - 1);
		if (j < n - 1 && grid[i][j + 1] != -2)
			union(grid, i, j, i, j + 1);
	}

	private void union(int[][] grid, int i1, int j1, int i2, int j2) {
		int find = find(grid, i2, j2);
		if(find != i1 * n + j1){
		grid[find / n][find % n] = i1 * n + j1;
		count--;
		}
	}

	private int find(int[][] grid, int i, int j) {
		if (grid[i][j] == -1)
			return i * n + j;
		int i2 = grid[i][j] / n;
		int j2 = grid[i][j] % n;
		return find(grid, i2, j2);
	}

	public static void main(String[] args) {
		NumberOfIslandsII s = new NumberOfIslandsII();
		int positions[][] = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 1 },
				{ 1, 0 }, {0, 2}, {0, 0}, {1, 1} };
		//[[0,1],[1,2],[2,1],[1,0],[0,2],[0,0],[1,1]]
		// int positions[][] = new int[][] { { 0, 1 }, { 0, 0 }};
		System.out.println(s.numIslands2(3, 3, positions));
	}
}