import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TheSkylineProblem {
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> result = new ArrayList<>();
		List<int[]> height = new ArrayList<>();
		if (buildings.length == 0) {
			return result;
		}
		for (int[] b : buildings) {
			height.add(new int[] { b[0], b[2] });
			height.add(new int[] { b[1], -b[2] });
		}
		Collections.sort(height, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
		Queue<Integer> pq = new PriorityQueue<>(buildings.length, Collections.reverseOrder());
		pq.offer(0);
		int prev = 0;
		for (int[] h : height) {
			if (h[1] > 0) {
				pq.offer(h[1]);
			} else {
				pq.remove(-h[1]);
			}
			int cur = pq.peek();
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
		TheSkylineProblem s = new TheSkylineProblem();
		for (int[] arr : s.getSkyline(buildings)) {
			for (int i : arr) {
				System.out.print(i + ",");
			}
			System.out.println();
		}
	}
}