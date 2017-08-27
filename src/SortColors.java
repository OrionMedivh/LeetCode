
/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 */

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
		// left: right side of sorted 0s
		// index: right side of sorted 0s and 1s
		// right: left side of sorted 2s
		int index = 0, left = 0, right = nums.length - 1;

		// notice the ending condition is index<=right, because
		// the sorted part is [0-index) and (right, end]
		// [0-index) + (right, end] == [0-end] only when index == right
		while (index <= right) {
			if (nums[index] == 0) {
				swap(nums, index, left);
				left++;
				index++;
			} else if (nums[index] == 1) {
				index++;
			} else {
				swap(nums, index, right);
				right--;
				// no index++ here, because this step only add one sorted item
				// into the right side, not left side.
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
