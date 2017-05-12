
public class WallsAndGates {
	public void wallsAndGates(int[][] rooms) {
		if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
			return;
		}
		int m = rooms.length;
		int n = rooms[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == 0) {
					dfs(rooms, i, j, 0);
				}
			}
		}
	}

	private void dfs(int[][] rooms, int x, int y, int val) {
		if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || rooms[x][y] < val) {
			return;
		}
		rooms[x][y] = val;
		dfs(rooms, x + 1, y, val + 1);
		dfs(rooms, x - 1, y, val + 1);
		dfs(rooms, x, y + 1, val + 1);
		dfs(rooms, x, y - 1, val + 1);
	}
}
