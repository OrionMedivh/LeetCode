
/*
Given a column title as appear in an Excel sheet, 
return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 */

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		int result = 0;
		for (char c : s.toCharArray()) {
			result *= 26;
			if (c >= 'A' && c <= 'Z') {
				result += c - 'A' + 1;
			}
		}
		return result;
	}
}
