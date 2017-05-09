
public class AddBinary {
	public String addBinary(String a, String b) {
		if (a == null || b == null) {
			return "";
		}
		StringBuffer result = new StringBuffer();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int digit = 0;
		while (i >= 0 || j >= 0) {
			if (i >= 0) {
				digit += a.charAt(i) - '0';
				i--;
			}
			if (j >= 0) {
				digit += b.charAt(j) - '0';
				j--;
			}
			result.append(digit % 2);
			digit /= 2;
		}
		if (digit == 1) {
			result.append(1);
		}
		return result.reverse().toString();
	}
}
