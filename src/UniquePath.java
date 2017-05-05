public class UniquePath {
	public int uniquePaths(int m, int n) {
		if (m <= 0 || n <= 0)
			return 0;
		if (m == 1 && n == 1)
			return 1;
		int[] line = new int[m];
		for (int i = 0; i < m; i++) {
			line[i] = 1;
		}
		for (int i = 1; i < n; i++) { // line[0] is always 1. so don't change
										// it.
			for (int j = 1; j < m; j++) {
				line[j] = line[j] + line[j - 1];
			}
		}
		return line[m - 1];
	}

	public int uniquePaths2(int m, int n) {
		if (m <= 0 || n <= 0) {
			return 0;
		}
		int[][] paths = new int[m][n];
		for (int i = 0; i < m; i++) {
			paths[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			paths[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; i < n; j++) {
				paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
			}
		}
		return paths[m - 1][n - 1];
	}

	public static void main(String[] args) {
		UniquePath u = new UniquePath();
		System.out.println(u.uniquePaths2(2, 2));
	}
}