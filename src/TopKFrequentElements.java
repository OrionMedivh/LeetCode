import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Top K Frequent Elements
//https://leetcode.com/problems/top-k-frequent-elements/#/solutions
public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		//regular sort
		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		
		for(int n:map.keySet()){
			int freq = map.get(key)
		}
	}
}
