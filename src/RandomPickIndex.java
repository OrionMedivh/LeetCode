
// {1,2,3,3,3} with target 3, you want to select the 3 on index 2,3,4 with a probability of 1/3 each.
// 2:probability of selection is 1* (1/2)(probability of 2nd 3 not getting 0) * (2/3)(probability of 3rd 3 not getting 0) =1/3
// 3:Its probability of selection is (1/2) * (2/3) = 1/3
// 4:Its probability of selection is just 1/3
// So they are each randomly selected.

import java.util.Random;

public class RandomPickIndex {
	int[] nums;
	Random rnd;

	public RandomPickIndex(int[] nums) {
		this.nums = nums;
		this.rnd = new Random();
	}

	public int pick(int target) {
		int result = -1;
		int count = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != target) {
				continue;
			}
			if (rnd.nextInt(count++) == 0)
				result = i;
		}
		return result;
	}
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int param_1 = obj.pick(target);
 */