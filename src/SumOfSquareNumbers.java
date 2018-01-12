import java.util.HashSet;

/*
Given a non-negative integer c, your task is to decide whether 
there're two integers a and b such that a2 + b2 = c.

Example 1:
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:
Input: 3
Output: False
 */

public class SumOfSquareNumbers {
	public boolean judgeSquareSum(int c) {
		if (c < 0) {
			return false;
		}
		int i = 0, j = (int) Math.sqrt(c);
		while (i <= j) {
			int cur = i * i + j * j;
			if (cur < c) {
				i++;
			} else if (cur > c) {
				j--;
			} else {
				return true;
			}
		}
		return false;
	}
	
	public boolean judgeSquareSum2(int c) {
		for (int i = 0; i * i <= c; i++) {
			if (((int)Math.sqrt(c - i * i)) == Math.sqrt(c - i * i)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean judgeSquareSum3(int c) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i <= Math.sqrt(c); i++) {
            set.add(i * i);
            if (set.contains(c - i * i)) {
                return true;
            }
        }
        return false;
	}
}
