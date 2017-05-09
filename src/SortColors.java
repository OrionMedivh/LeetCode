
public class SortColors {
	// bucket sort
	public void sortColors2(int[] nums) {
		int[] color = new int[3];
		for (int i : nums) {
			color[i]++;
		}
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < color[i]; j++) {
				nums[count] = i;
				count++;
			}
		}
	}

	// two pointers
	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int index = 0, left = 0, right = nums.length - 1;
		while (index <= right) { // <=, eg. [1,0]
			if (nums[index] == 0) {
				swap(nums, index, left);
				left++;
				index++;
			} else if (nums[index] == 1) {
				index++;
			} else {
				swap(nums, index, right);
				right--;
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
