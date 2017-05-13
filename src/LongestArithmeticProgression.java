import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LongestArithmeticProgression {
	public int longestArithmeticProgression(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();
		// diff -> pair of indices (diff = 2 : all pairs {1,3} {3,5} {5,7} ...)
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int diff = nums[j] - nums[i];
				if (!map.containsKey(diff)) {
					map.put(diff, new ArrayList<>());
				}
				ArrayList<Integer> pair = new ArrayList<>(Arrays.asList(i, j));
				map.get(diff).add(pair);
			}
		}
		int max = 0;
		for (int key : map.keySet()) {
			int[] lengths = new int[nums.length];
			for (int i = 0; i < lengths.length; i++) {
				lengths[i] = 1;
			}
			for (ArrayList<Integer> pair : map.get(key)) {
				lengths[pair.get(1)] = lengths[pair.get(0)] + 1;
				max = Math.max(max, lengths[pair.get(1)]);

			}
		}
		return max;
	}
}
