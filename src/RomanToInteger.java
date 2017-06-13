import java.util.HashMap;

/*
Given a Roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
 */

public class RomanToInteger {
	public int romanToInt(String s) {
		HashMap<Character, Integer> plus = new HashMap<>();
		plus.put('I', 1);
		plus.put('V', 5);
		plus.put('X', 10);
		plus.put('L', 50);
		plus.put('C', 100);
		plus.put('D', 500);
		plus.put('M', 1000);

		HashMap<String, Integer> minus = new HashMap<>();
		minus.put("IV", 2);
		minus.put("IX", 2);
		minus.put("XL", 20);
		minus.put("XC", 20);
		minus.put("CD", 200);
		minus.put("CM", 200);

		int res = 0;
		for (char c : s.toCharArray()) {
			res += plus.getOrDefault(c, 0);
		}

		for (String str : minus.keySet()) {
			if (s.indexOf(str) != -1) {
				res -= minus.get(str);
			}
		}
		return res;
	}
}
