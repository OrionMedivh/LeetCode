public class SparseMatrixMultiplication {
	public int[][] multiply(int[][] A, int[][] B) {
		if (A.length == 0 || A[0].length == 0 || B.length == 0 || B[0].length == 0 || A[0].length != B.length) {
			return new int[][] {};
		}
		int m = A.length, p = A[0].length, n = B[0].length;
		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int k = 0; k < p; k++) {
				if (A[i][k] != 0) {
					for (int j = 0; j < n; j++) {
						if (B[k][j] != 0) {
							res[i][j] += A[i][k] * B[k][j];
						}
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		SparseMatrixMultiplication s = new SparseMatrixMultiplication();
		int[][] A = new int[][] { { 1, 0, 0 }, { -1, 0, 3 } };
		int[][] B = new int[][] { { 7, 0, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };
		System.out.print(s.multiply(A, B));
	}
}