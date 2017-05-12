import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBetweenTwoUndirectedGraphNodes {
	public int shortestPath(UndirectedGraphNode a, UndirectedGraphNode b) {
		if (a == null || b == null) {
			return -1;
		}
		// bfs
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		HashSet<UndirectedGraphNode> set = new HashSet<>();
		int res = 0;
		queue.offer(a);
		set.add(a);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				UndirectedGraphNode curr = queue.poll();
				if (curr == b) {
					return res;
				}
				for (UndirectedGraphNode neighbor : curr.neighbors) {
					if (set.contains(neighbor)) {
						continue;
					}
					queue.offer(neighbor);
					set.add(neighbor);
				}
			}
			res++;
		}
		return -1;
	}
}
