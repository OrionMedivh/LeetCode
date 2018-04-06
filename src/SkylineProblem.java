import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SkylineProblem {
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> result = new ArrayList<>();
		// corner cases go first
		if (buildings.length == 0) {
			return result;
		}
		// extract edges from buildings
		// height going up is positive, while going down is negative
		List<int[]> height = new ArrayList<>();
		for (int[] b : buildings) {
			height.add(new int[] { b[0], b[2] });
			height.add(new int[] { b[1], -b[2] });
		}
		// sort edges by x axis asc, then y axis desc
		Collections.sort(height, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
		// create a max heap with size n.
		Queue<Integer> pq = new PriorityQueue<>(buildings.length, Collections.reverseOrder());
		pq.offer(0);
		int prev = 0;
		for (int[] h : height) {
			if (h[1] > 0) {
				// if height is positive, add to heap
				pq.offer(h[1]);
			} else {
				// negative height, remove from heap
				pq.remove(-h[1]);
			}
			int cur = pq.peek();
			// if current max height changes, add the edge.
			if (prev != cur) {
				result.add(new int[] { h[0], cur });
				prev = cur;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// int[][] buildings = new int[][]{{2,9,10}, {3,7,15}, {5,12,12},
		// {15,20,10}, {19,24,8}};
		// int[][] buildings = new int[][] { { 0, 2, 3 }, { 2, 5, 3 } };
		int[][] buildings = new int[][] {};
		SkylineProblem s = new SkylineProblem();
		for (int[] arr : s.getSkyline(buildings)) {
			for (int i : arr) {
				System.out.print(i + ",");
			}
			System.out.println();
		}
	}
}