/*
Given an array of integers, every element appears twice except for one. 
Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement 
it without using extra memory?
 */

/*
 * The idea is using 'exclusive or', since an exclusive or with a number
 * itself will result in 0. So the only one left is the single number.
 */

public class SingleNumber {
	public int singleNumber(int[] nums) {
		int res = 0;
		for (int i : nums) {
			res ^= i;
		}
		return res;
	}
}
