import java.util.ArrayList;

public class SortCharactersByFrequency {
	public String frequencySort(String s) {
		int[] buckets = new int[128];
		for (char c : s.toCharArray()) {
			buckets[c]++;
		}

		ArrayList<Character>[] frequency = new ArrayList[s.length() + 1];
		for (int i = 0; i < 128; i++) {
			if (buckets[i] != 0) {
				if (frequency[buckets[i]] == null) {
					frequency[buckets[i]] = new ArrayList<Character>();
				}
				frequency[buckets[i]].add((char) i);
			}
		}

		char[] result = new char[s.length()];
		int p = 0;
		for (int i = s.length(); i > 0; i--) { // index of frequency
			ArrayList<Character> list = frequency[i];
			if (list == null) {
				continue;
			}
			for (int j = 0; j < list.size(); j++) {
				char c = list.get(j);
				for (int k = 0; k < i; k++) { // number of repeated times
					result[p] = c;
					p++;
				}
			}
		}
		return new String(result);
	}

	public static void main(String[] args) {
		SortCharactersByFrequency s = new SortCharactersByFrequency();
		System.out.println(s.frequencySort("tree"));
	}
}