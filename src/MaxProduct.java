
public class MaxProduct {
	public int maxProduct(int[] nums) {
		if (nums == null)
			return 0;
		int curmax = nums[0];
		int curmin = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int prevmin = curmin;
			int prevmax = curmax;
			curmin = Math.min(nums[i], Math.min(prevmin * nums[i], prevmax * nums[i]));
			curmax = Math.max(nums[i], Math.max(prevmin * nums[i], prevmax * nums[i]));
			max = Math.max(max, curmax);
		}
		return max;
	}

	public static void main(String[] args) {
		MaxProduct s = new MaxProduct();
		int[] nums = new int[] { 2, -5, -2, -4, 3 };
		System.out.println(s.maxProduct(nums));
	}
}
