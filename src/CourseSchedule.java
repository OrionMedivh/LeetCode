import java.util.LinkedList;
import java.util.Queue;

/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
click to show more hints.

Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
 */

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// create a courses array with courses[i] = j
		// means course i has a total of j prerequisites
		int[] courses = new int[numCourses];
		// calculate prerequisites of the courses
		for (int[] pair : prerequisites) {
			courses[pair[0]]++;
		}
		// create a queue to take courses in order
		Queue<Integer> queue = new LinkedList<Integer>();
		// add all courses don't need prerequisites
		for (int i = 0; i < numCourses; i++) {
			if (courses[i] == 0) {
				queue.add(i);
			}
		}
		while (!queue.isEmpty()) {
			// get a course from head of queue, take this course
			int course = queue.poll();
			// reduce remaining number of courses
			numCourses--;
			// for every pair in the prerequisites
			for (int[] pair : prerequisites) {
				// if course X is depend on this course
				if (pair[1] == course) {
					// reduce the number of prerequisite of course X
					courses[pair[0]]--;
					// if course X doesn't have any other prerequisite
					if (courses[pair[0]] == 0) {
						// add course X into queue
						queue.add(pair[0]);
					}
				}
			}
		}
		// if all courses taken, return true; otherwise return false.
		return numCourses == 0;
	}
}
