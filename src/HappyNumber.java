import java.util.HashSet;
import java.util.Set;

/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: 
Starting with any positive integer, replace the number by the 
sum of the squares of its digits, and repeat the process until 
the number equals 1 (where it will stay), or it loops endlessly 
in a cycle which does not include 1. Those numbers for which 
this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */

public class HappyNumber {
	public boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<>();
		set.add(n);
		return isHappy(n, set);
	}

	private boolean isHappy(int n, Set<Integer> set) {
		int square = calculate(n);
		if (set.contains(square)) {
			if (square == 1) {
				return true;
			} else {
				return false;
			}
		} else {
			set.add(square);
			return isHappy(square, set);
		}
	}

	private int calculate(int n) {
		int res = 0;
		while (n != 0) {
			res += (n % 10) * (n % 10);
			n /= 10;
		}
		return res;
	}
}
