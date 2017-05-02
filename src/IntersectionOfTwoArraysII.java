import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> result = new ArrayList<>();
		for (int num : nums1) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for (int num : nums2) {
			if (map.containsKey(num)) {
				result.add(num);
				int freq = map.get(num);
				if (--freq == 0) {
					map.remove(num);
				} else {
					map.put(num, freq);
				}
			}
		}
		int[] res = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			res[i] = result.get(i);
		}
		return res;
	}
}
