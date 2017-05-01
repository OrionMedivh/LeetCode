/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class FindTheCelebrity {
	public int findCelebrity(int n) {
		int candidate = 0;
		for (int i = 1; i < n; i++) {
			if (knows(candidate, i)) {
				candidate = i;
			}
		}
		for (int i = 0; i < n; i++) {
			if (candidate != i && (knows(candidate, i) || !knows(i, candidate))) {
				return -1;
			}
		}
		return candidate;
	}

	private boolean knows(int a, int b) {
		return Math.random() >= 0.5;
	}
}
