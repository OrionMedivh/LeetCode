import java.util.HashMap;
import java.util.Map;

//Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

public class SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		int sum = 0, result = 0;
		Map<Integer, Integer> map = new HashMap<>();
		// value -> how many occurrence
		map.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				result += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return result;
	}
}
