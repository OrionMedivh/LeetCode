package youknow;

import java.util.*;

public class FindRepeatedDNASequence {
	// public List<String> findRepeatedDnaSequences(String s) {
	// List<String> result = new ArrayList<String>();
	// if (s.length() <= 10)
	// return result;
	// int size = 10;
	// for (int start = 0; start < s.length() - size; start++) {
	// int start2 = start + size;
	// for (; start2 < s.length() - size; start2++) {
	// if (s.charAt(start) != s.charAt(start2)) continue;
	// int end = start;
	// int end2 = start2;
	// for (; end < start + size; end++,end2++) {
	// if (s.charAt(end) != s.charAt(end2)) break;
	// }
	// if (start + size == end)
	// result.add(s.substring(start, end));
	// }
	// }
	// return result;
	// }

	// public List<String> findRepeatedDnaSequences(String s) {
	// List<String> result = new ArrayList<String>();
	// if (s.length() <= 10)
	// return result;
	// int size = 10;
	// for (int start = 0; start < s.length() - size; start++) {
	// for (int start2 = start + size; start2 < s.length() - size; start2++) {
	// if
	// (s.substring(start,start+size).equals(s.substring(start2,start2+size)))
	// result.add(s.substring(start,start+size));
	// }
	// }
	// return result;
	// }

	public List<String> findRepeatedDnaSequences(String s) {
		HashSet<String> result = new HashSet<String>();
		HashSet<String> set = new HashSet<String>();
		int size = 10;
		for (int start = 0; start <= s.length() - size; start++) {
			String sub = s.substring(start, start + size);
			if (!set.add(sub))
				result.add(sub);
		}
		return new ArrayList<String>(result);
	}

	public static void main(String[] args) {
		FindRepeatedDNASequence s = new FindRepeatedDNASequence();
//		System.out.println(s
//				.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println(s
				.findRepeatedDnaSequences("AAAAAAAAAAAA"));
	}
}