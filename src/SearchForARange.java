
/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */

public class SearchForARange {
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[] { -1, -1 };
		if(nums == null || nums.length == 0){
			return result;
		}
		
		int i = 0, j = nums.length - 1;
		while (i < j) {
			int mid = i + (j - i) / 2;
			if (nums[mid] >= target) {
				j = mid;
			} else {
				i = mid + 1;
			}
		}

		if (nums[i] != target) {
			return result; // didn't find
		}
		result[0] = i;

		// i = 0; not needed;
		j = nums.length - 1;
		// mirror the previous condition
		while (i < j) {
			int mid = i + (j - i) / 2 + 1; // lean towards right
			if (nums[mid] <= target) {
				i = mid;
			} else {
				j = mid - 1;
			}
		}
		result[1] = j;

		return result;
	}
}
