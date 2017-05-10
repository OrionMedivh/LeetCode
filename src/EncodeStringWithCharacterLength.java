
public class EncodeStringWithCharacterLength {
	public String encodeStringWithCharLength(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
			int count = 1;
			while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
				count++;
				i++;
			}
			sb.append(count);
		}
		return sb.toString();
	}
}
