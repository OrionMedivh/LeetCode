
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int index = 0; // swap location
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				// swap everything non-0 to the head of the list
				int tmp = nums[i];
				nums[i] = nums[index];
				nums[index] = tmp;
				index++;
			}
		}
	}
}
