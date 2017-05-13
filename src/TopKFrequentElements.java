import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Top K Frequent Elements
//https://leetcode.com/problems/top-k-frequent-elements/#/solutions
public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		// Bucket sort
		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> frequencymap = new HashMap<>();
		for (int n : nums) {
			frequencymap.put(n, frequencymap.getOrDefault(n, 0) + 1);
		}

		for (int key : frequencymap.keySet()) {
			int frequency = frequencymap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}

		List<Integer> res = new ArrayList<>();

		for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}
		return res;
	}
}
