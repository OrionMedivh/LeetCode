public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		int[] cnt = new int[256];
		for (char c : t.toCharArray()) {
			cnt[c]++;
		}
		int min = Integer.MAX_VALUE, from = 0, total = t.length();
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (cnt[s.charAt(i)]-- > 0) {
				total--;
			}
			while (total == 0) { // total = 0 means all chars in t has been
									// found
				if (i - j + 1 < min) {
					min = i - j + 1;
					from = j;
				}
				if (++cnt[s.charAt(j++)] > 0) // not enough chars in window
					total++;
			}
		}
		return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
	}
}