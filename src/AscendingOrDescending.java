
// to see if it is an ascending or descending array.

public class AscendingOrDescending {
	public boolean isAscendingOrDescending(int[] nums) {
		if (nums == null || nums.length < 2) {
			return true;
		}
		if (nums[0] > nums[nums.length - 1]) {
			// check if it's descending monotonous
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] >= nums[i - 1]) {
					return false;
				}
			}
			return true;
		} else if (nums[0] < nums[nums.length - 1]) {
			// check if it's ascending monotonous
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] <= nums[i - 1]) {
					return false;
				}
			}
			return true;
		} else {
			return false; // nums[0] == nums[nums.length-1];
		}
	}
}
