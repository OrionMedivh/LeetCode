import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] result = new int[numCourses];
		int index = 0;
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
			result[index] = course;
			index++;
			for (int[] pair : prerequisites) {
				if (pair[1] == course) {
					indegree[pair[0]]--;
					if (indegree[pair[0]] == 0) {
						queue.add(pair[0]);
					}
				}
			}
		}
		if (numCourses == 0) {
			return result;
		} else {
			return new int[0];
		}
	}
}
