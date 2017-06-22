
/*
 * Define amazing number as: its value is less than or equal to its index. 
 * Given a circular array, find the starting position, such that the total 
 * number of amazing numbers in the array is maximized.
 * Example 1: 0, 1, 2, 3
 * Ouptut: 0.    When starting point at position 0, all the elements in the 
 * array are equal to its index. So all the numbers are amazing number.
 * Example 2: 1, 0 , 0.
 * Output: 1.    When starting point at position 1, the array becomes 0, 0, 1. 
 * All the elements are amazing number.
 * If there are multiple positions, return the smallest one..
 */

public class AmazingNumber {
	public int amazingNumber(int[] nums) {
		int res = 0;
		int max = 0;
		// check every starting position
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			// count how many amazing number:
			// value less than or equal to index
			for (int j = 0; j < nums.length; j++) {
				if (j - nums[(i + j) % nums.length] >= 0) {
					count++;
				}
			}
			if (count > max) {
				max = count;
				res = i;
			}
		}
		return res;
	}
}
