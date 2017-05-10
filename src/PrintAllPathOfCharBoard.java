import java.util.ArrayList;
import java.util.List;

public class PrintAllPathOfCharBoard {
	public List<String> printAllPath(char[][] board) {
		List<String> res = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		dfs(board, res, sb, 0, 0);
		return res;
	}

	private void dfs(char[][] board, List<String> res, StringBuffer sb, int x, int y) {
		int len = sb.length();
		sb.append(board[y][x]);

		if (x == board[0].length - 1 && y == board.length - 1) {
			res.add(sb.toString());
		} else {
			if (x < board[0].length - 1) {
				dfs(board, res, sb, x + 1, y);
			}
			if (y < board.length) {
				dfs(board, res, sb, x, y + 1);
			}
		}
		sb.setLength(len);
	}
}
