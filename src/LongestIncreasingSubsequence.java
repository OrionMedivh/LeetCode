import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;

		for (int num : nums) {
			int i = Arrays.binarySearch(dp, 0, len, num);
			if (i < 0) {
				i = -(i + 1);
				// because binarySearch will return - (insert position) - 1 if
				// it's not found
			}
			dp[i] = num;
			if (i == len) {
				len++;
			}
		}
		return len;
	}

	/*
	 * 10, 9, 2, 5, 3, 7, 101, 18
	 * 
	 * 10
	 * 
	 * 9
	 * 
	 * 2
	 * 
	 * 2,5
	 * 
	 * 2,3
	 * 
	 * 2,3,7
	 * 
	 * 2,3,7,101
	 * 
	 * 2,3,7,18
	 */

	public int lengthOfLIS2(int[] nums) {
		int[] dp = new int[nums.length];
		int size = 0;

		for (int num : nums) {
			int i = 0, j = size;
			while (i < j) {
				int m = i + (j - i) / 2;
				if (dp[m] < num) {
					i = m + 1;
				} else {
					j = m;
				}
			}
			// think about why i is either the found index or insert
			// location
			dp[i] = num;
			if (i == size) {
				size++;
			}
		}
		return size;
	}
}
