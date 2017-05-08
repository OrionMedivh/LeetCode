
public class SearchInRotatedArrayII {
	public boolean search(int[] nums, int target) {
		if (nums.length == 0) {
			return false;
		}
		return search(nums, target, 0, nums.length - 1);
	}

	private boolean search(int[] nums, int target, int begin, int end) {
		if (begin >= end) {
			if (nums[begin] == target) {
				return true;
			}
			return false;
		}
		int middle = begin + (end - begin) / 2;
		if (nums[middle] == target) {
			return true;
		}
		if (nums[end] < nums[middle]) {
			if (nums[middle] > target && nums[begin] <= target) {
				return search(nums, target, begin, middle - 1);
			}
			return search(nums, target, middle + 1, end);
		} else if (nums[end] > nums[middle]) {
			if (nums[middle] < target && nums[end] >= target) {
				return search(nums, target, middle + 1, end);
			}
			return search(nums, target, begin, middle - 1);
		} else {
			return search(nums, target, begin, end - 1);
		}
	}
}
