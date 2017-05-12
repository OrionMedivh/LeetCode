
public class SplitArrayLargestSum {
	public int splitArray(int[] nums, int m) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		long sum = 0; // total sum
		int max = 0; // max num in array
		for (int num : nums) {
			sum += num;
			max = Math.max(max, num);
		}
		if (m == 1)
			return (int) sum;
		long l = max, r = sum;
		while (l <= r) {
			long mid = (l + r) / 2;
			if (valid(mid, nums, m)) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return (int) l;
	}

	private boolean valid(long target, int[] nums, int m) {
		int count = 1; // num of arrays
		long total = 0;
		for (int num : nums) {
			total += num;
			if (total > target) { // need a new subarray
				total = num;
				count++;
				if (count > m) {
					return false;
				}
			}
		}
		return true;
	}
}
