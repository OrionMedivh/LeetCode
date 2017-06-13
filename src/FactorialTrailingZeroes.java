
/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
 */

// Idea: 0-24 = n/5,  25-124 = n/5 + n/25, ...

public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		return n == 0 ? 0 : (n / 5 + trailingZeroes(n / 5));
	}
}
