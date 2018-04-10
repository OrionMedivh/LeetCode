import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

//https://leetcode.com/problems/top-k-frequent-elements/#/solutions
public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		// Bucket sort
		// a list of buckets with frequency -> elements
		List<Integer>[] bucket = new List[nums.length + 1];
		// frequency map, elements -> frequency
		Map<Integer, Integer> frequencymap = new HashMap<>();
		// create frequency map data
		for (int n : nums) {
			frequencymap.put(n, frequencymap.getOrDefault(n, 0) + 1);
		}
		// transfer data from frequency map to buckets
		for (int key : frequencymap.keySet()) {
			int frequency = frequencymap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}
		// take top k most frequent elements from buckets
		List<Integer> res = new ArrayList<>();
		for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}
		return res;
	}
}
