public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 1) {
			return;
		}
		int i = nums.length - 1;
		while (i >= 1 && nums[i - 1] >= nums[i]) {
			// find last trunk that is ascending order
			i--;
		}
		if (i >= 1) {
			int j = nums.length - 1;
			while (nums[j] <= nums[i - 1]) {
				// find the index will give minimum increase
				j--;
			}
			swap(nums, i - 1, j);
		}
		reverse(nums, i, nums.length - 1); // reverse sorting
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private void reverse(int[] nums, int i, int j) {
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}
}