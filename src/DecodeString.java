import java.util.Stack;

public class DecodeString {
	public String decodeString(String s) {
		Stack<Integer> count = new Stack<>();
		Stack<StringBuffer> result = new Stack<>();
		int i = 0;
		result.push(new StringBuffer());
		while (i < s.length()) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				int start = i;
				while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
					i++;
				}
				count.push(Integer.parseInt(s.substring(start, i + 1)));
			} else if (c == '[') {
				result.push(new StringBuffer());
			} else if (c == ']') {
				StringBuffer pop = result.pop();
				StringBuffer sb = new StringBuffer();
				int times = count.pop();
				for (int j = 0; j < times; j += 1) {
					sb.append(pop);
				}
				result.peek().append(sb);
			} else {
				result.peek().append(c);
			}
			i += 1;
		}
		return result.pop().toString();
	}
}
