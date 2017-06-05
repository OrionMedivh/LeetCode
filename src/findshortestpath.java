import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Welcome to Facebook!

//This is just a simple shared plaintext pad, with no execution capabilities.

//When you know what language you'd like to use for your interview,
//simply choose it from the dropdown in the top bar.

//Enjoy your interview!

//Given a game board, represented as 2D array of zeroes and ones. Zero stands for passible positions and one stands for impassable positions. Design an algorithm to find the shortest path from top left corner to bottom right corner. For example, given a board of the following, the shortest path is denoted by + on the second board.

//0 0 0 0 0 0 0
//0 0 1 0 0 1 0
//0 0 1 0 1 1 0
//0 0 1 0 1 0 1
//1 1 1 0 0 0 0

//The shortest path:

//+ + + + 0 0 0
//0 0 1 + 0 1 0
//0 0 1 + 1 1 0
//0 0 1 + 1 0 1
//1 1 1 + + + +

//For this question, let's return (0, 0) -> (0, 1) -> (0, 2) -> (0, 3) -> (1, 3) -> (2, 3) -> (3, 3) -> (4, 3) -> (4, 4) -> (4, 5) -> (4, 6)

public class findshortestpath {

	private final int[] directions = new int[] { 1, 0, -1, 0, 1 };

	public List<int[]> findShortestPath(int[][] board) {
		List<int[]> res = new ArrayList<>();
		if (board == null || board.length == 0 || board[0].length == 0) {
			return res;
		}
		int m = board.length;
		int n = board[0].length;

		Queue<List<int[]>> paths = new LinkedList<>();
		List<int[]> path = new LinkedList<int[]>();
		path.add(new int[] { 0, 0 });
		paths.offer(path);
		Queue<int[]> queue = new LinkedList<>();
		int[] current = new int[] { 0, 0 };
		queue.offer(current);
		board[0][0] = 1;

		while (!queue.isEmpty()) {
			current = queue.poll();
			path = paths.poll();
			if (current[0] == m - 1 && current[1] == n - 1) {
				return path;
			}
			traverse(current, queue, path, paths, m, n, board);
		}
		return res;
	}

	private void traverse(int[] current, Queue<int[]> queue, List<int[]> path, Queue<List<int[]>> paths, int m, int n,
			int[][] board) {
		for (int i = 0; i < 4; i++) {
			int[] next = new int[] { current[0] + directions[i], current[1] + directions[i + 1] };
			if (next[0] >= 0 && next[0] < m && next[1] >= 0 && next[1] < n && board[next[0]][next[1]] == 0) {
				queue.offer(next);
				List<int[]> newpath = new ArrayList<>(path);
				newpath.add(next);
				paths.offer(newpath);
				board[next[0]][next[1]] = 1;
			}
		}
	}

	public void print(List<int[]> res) {
		System.out.println("");
		for (int[] pair : res) {
			System.out.println(pair[0] + " " + pair[1]);
		}
	}

	public static void main(String[] args) {
		findshortestpath f = new findshortestpath();
		int[][] board = new int[1][1];
		f.print(f.findShortestPath(board));
		board = new int[2][2];
		f.print(f.findShortestPath(board));
		board = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 1 },
				{ 1, 1, 0, 0, 0 } };
		f.print(f.findShortestPath(board));
	}
}