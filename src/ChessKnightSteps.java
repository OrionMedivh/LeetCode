import java.util.LinkedList;
import java.util.Queue;

public class ChessKnightSteps {

	private final int[][] moves = new int[][] { { 1, 2 }, { 2, 1 }, { -1, 2 }, { -2, 1 }, { 1, -2 }, { 2, -1 },
			{ -1, -2 }, { -2, -1 } };

	public int knightToTarget(int[][] matrix, int x1, int y1, int x2, int y2) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return -1;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		Queue<int[]> queue = new LinkedList<>(); // bfs
		boolean[][] visited = new boolean[m][n];
		int steps = 0;
		queue.offer(new int[] { x1, y1 });
		visited[x1][y1] = true;
		while (!queue.isEmpty()) {
			int size = queue.size(); // current batch of the same steps
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				if (cur[0] == x2 && cur[1] == y2) {
					return steps;
				}
				for (int j = 0; j < moves.length; j++) {
					int nextX = x1 + moves[j][0];
					int nextY = y1 + moves[j][1];
					if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
						queue.offer(new int[] { nextX, nextY });
						visited[nextX][nextY] = true;
					}
				}
			}
			steps++; // queue of current steps is cleared
		}
		return -1;
	}
}
