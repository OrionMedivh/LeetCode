
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 
6 units of rain water (blue section) are being trapped.
 */

public class TrappingRainWater {
	public int trap(int[] A) {
		int n = A.length;
		if (n <= 2)
			return 0;

		int[] left = new int[n];
		int[] right = new int[n];

		left[0] = A[0];
		right[n - 1] = A[n - 1];
		// left bound
		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i - 1], A[i]);
		}
		// right bound
		for (int i = n - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], A[i]);
		}
		// trapped rain
		int rain = 0;
		for (int i = 0; i < n; i++) {
			rain += Math.min(left[i], right[i]) - A[i];
		}
		return rain;
	}
}
