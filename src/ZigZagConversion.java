public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows <= 1) {
			return s;
		}
		if (s.equals("")) {
			return "";
		}
		StringBuffer[] list = new StringBuffer[numRows];
		// Arrays.fill(list, new StringBuffer()); // fatal error
		for (int i = 0; i < numRows; i++) {
			list[i] = new StringBuffer();
		}
		int index = 0, direction = 1;
		for (char ch : s.toCharArray()) {
			list[index].append(ch);
			index += direction;
			if (index == numRows - 1) {
				direction = -1;
			}
			if (index == 0) {
				direction = 1;
			}
		}
		StringBuffer res = new StringBuffer();
		for (StringBuffer sb : list) {
			res.append(sb);
		}
		return res.toString();
	}

	public static void main(String[] args) {
		ZigZagConversion z = new ZigZagConversion();
		System.out.println(z.convert("A", 2));
	}
}
