
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || word == null
				|| word.length() == 0) {
			return false;
		}
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (word.charAt(0) == board[i][j]) {
					if (exist(board, word, i, j, 0)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean exist(char[][] board, String word, int i, int j, int index) {
		if (index == word.length()) {
			return true;
		}
		int m = board.length;
		int n = board[0].length;
		if (i < 0 || i >= m || j < 0 || j >= n || word.charAt(index) != board[i][j]) {
			return false;
		}
		board[i][j] = '*'; // prevent from traversing back
		boolean res = exist(board, word, i + 1, j, index + 1) || exist(board, word, i - 1, j, index + 1)
				|| exist(board, word, i, j + 1, index + 1) || exist(board, word, i, j - 1, index + 1);
		board[i][j] = word.charAt(index); // change back
		return res;
	}
}
