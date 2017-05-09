import java.util.HashSet;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : A) {
			if (i > 0)
				set.add(i);
		}
		int m = 1;
		while (set.contains(m)) {
			m++;
		}
		return m;
	}
}
