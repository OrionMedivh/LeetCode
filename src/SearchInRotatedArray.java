public class SearchInRotatedArray {
	public int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		return search(nums, target, 0, nums.length - 1);
	}

	private int search(int[] nums, int target, int begin, int end) {
		if (begin == end) {
			if (nums[begin] == target) {
				return begin;
			}
			return -1;
		}
		int middle = begin + (end - begin) / 2;
		if (nums[begin] <= nums[middle]) { // this side is sorted
			if (nums[middle] >= target && nums[begin] <= target) {
				return search(nums, target, begin, middle);
			}
			return search(nums, target, middle + 1, end);
		} else {// the other side is sorted
			if (nums[middle] < target && nums[end] >= target) {
				return search(nums, target, middle + 1, end);
			}
			return search(nums, target, begin, middle);
		}
	}
}