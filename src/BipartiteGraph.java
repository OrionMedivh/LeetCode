import java.util.LinkedList;

public class BipartiteGraph {
	public boolean isBipartite(int G[][], int V) {
		int colorArr[] = new int[V];
		for (int i = 0; i < V; i++) {
			colorArr[i] = -1;
		}
		colorArr[0] = 1;

		LinkedList<Integer> q = new LinkedList<>();
		q.add(0);

		while (q.size() != 0) {
			int u = q.poll();
			for (int v = 0; v < V; v++) {
				if (G[u][v] == 1 && colorArr[v] == -1) {
					colorArr[v] = 1 - colorArr[u];
					q.offer(v);
				} else if (G[u][v] == 1 && colorArr[v] == colorArr[u]) {
					return false;
				}
			}
		}
		return true;
	}
}
