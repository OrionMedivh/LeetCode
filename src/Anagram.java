import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
 * which question is this?
 */

public class Anagram {
	public ArrayList<String> anagrams(String[] strs) {
		HashSet<Integer> set = new HashSet<Integer>();
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> strings = new ArrayList<String>();
		for (String a : strs) {
			char[] ca = a.toCharArray();
			Arrays.sort(ca);
			strings.add(new String(ca));
		}
		for (int i = 0; i < strings.size() - 1; i++) {
			if (set.contains(i)) {
				continue;
			} else {
				for (int j = i + 1; j < strings.size(); j++) {
					if (strings.get(i).length() == strings.get(j).length() && strings.get(i).equals(strings.get(j))) {
						set.add(i);
						set.add(j);
					}
				}
			}
			for (int index : set) {
				result.add(strs[index]);
			}
		}
		return result;
	}
}