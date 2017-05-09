
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null) {
			return "0";
		}
		int m = num1.length(), n = num2.length();
		int[] digits = new int[m + n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int p1 = i + j, p2 = i + j + 1;
				int sum = product + digits[p2];
				digits[p1] += sum / 10;
				digits[p2] = sum % 10;
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int p : digits) {
			if (sb.length() == 0 && p == 0) {
				continue; // skip zeros at front
			}
			sb.append(p);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}
}
