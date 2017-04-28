
public class ReverseWordsInAStringII {
	public void reverseWords(char[] s) {
		reverse(s, 0, s.length - 1); // reverse the entire string
		int start = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == ' ') {
				reverse(s, start, i - 1); // reverse everything between two
											// spaces.
				start = i + 1;
			}
		}
		reverse(s, start, s.length - 1);
	}

	public void reverse(char[] s, int start, int end) {
		while (start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
	}
}
