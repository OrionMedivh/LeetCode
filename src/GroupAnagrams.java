import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			// Arrays.sort(chars); // slow
			sort(chars);
			String newStr = new String(chars);
			if (map.containsKey(newStr)) {
				res.get(map.get(newStr)).add(str);
			} else {
				map.put(newStr, res.size());
				res.add(new ArrayList<>(Arrays.asList(str)));
			}
		}
		return res;
	}

	private void sort(char[] chars) {
		int[] buckets = new int[26];
		// create a character -> occurence map
		// aab -> a[2]b[1]
		for (char ch : chars) {
			buckets[ch - 'a']++;
		}
		int index = 0;
		// create chars from occurence map
		// d[3]f[4] -> dddffff
		for (int i = 0; i < buckets.length; i++) {
			while (buckets[i] > 0) {
				chars[index] = (char) (i + 'a');
				buckets[i]--;
				index++;
			}
		}
	}
}
