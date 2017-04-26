/*
 * Find the contiguous subarray within an array 
 * (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */

public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if (nums == null)
			return 0;
		int curmax = nums[0], curmin = nums[0], max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int prevmin = curmin, prevmax = curmax;
			curmin = Math.min(nums[i], Math.min(prevmin * nums[i], prevmax * nums[i]));
			curmax = Math.max(nums[i], Math.max(prevmin * nums[i], prevmax * nums[i]));
			max = Math.max(max, curmax);
		}
		return max;
	}
}
