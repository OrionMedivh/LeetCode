import java.util.HashMap;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		// create a map of value -> index
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			// in each step check if already exists a value + current number = target
			if (map.containsKey(target - nums[i])) {
				// if so, return a new pair[index of the value, current index]
				return new int[] { map.get(target - nums[i]), i };
			}
			// otherwise, put current value into the map
			map.put(nums[i], i);
		}
		// if not found, return [-1,-1]
		return new int[] { -1, -1 };
	}
}