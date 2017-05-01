import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int[] pair : prerequisites) {
			indegree[pair[0]]++;
		}
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		while (!queue.isEmpty()) {
			numCourses--;
			int course = queue.poll();
			for (int[] pair : prerequisites) {
				if (pair[1] == course) {
					indegree[pair[0]]--;
					if (indegree[pair[0]] == 0) {
						queue.add(pair[0]);
					}
				}
			}
		}
		return numCourses == 0;
	}
}
