import java.util.*;

/*
Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note: 
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Examples: 
input: 1
output: 
[]
input: 37
output: 
[]
input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
 */

public class FactorCombinations {
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		getFactors(n, 2, new ArrayList<Integer>(), result);
		return result;
	}

	private void getFactors(int n, int start, ArrayList<Integer> current, List<List<Integer>> result) {
		if (n <= 1)
			return;
		for (int i = start; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				ArrayList<Integer> sub = new ArrayList<Integer>(current);
				sub.add(i);
				getFactors(n / i, i, sub, result);
				sub.add(n / i);
				result.add(sub);
			}
		}
	}
}