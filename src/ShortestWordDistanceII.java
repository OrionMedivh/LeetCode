import java.util.*;

public class ShortestWordDistanceII {
	private HashMap<String, ArrayList<Integer>> WordsList;

	public ShortestWordDistanceII(String[] words) {
		WordsList = new HashMap<String, ArrayList<Integer>>();
		for (int i = 0; i < words.length; i++)
			if (WordsList.containsKey(words[i])) {
				WordsList.get(words[i]).add(i);
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				WordsList.put(words[i], list);
			}
	}

	public int shortest(String word1, String word2) {
		ArrayList<Integer> p1 = WordsList.get(word1);
		ArrayList<Integer> p2 = WordsList.get(word2);
		int min = Integer.MAX_VALUE;
		// for(int i:p1)
		// for(int j:p2)
		// min = Math.min(min, Math.abs(i-j));
		for (int i = 0, j = 0; i < p1.size() && j < p2.size();) {
			int index1 = p1.get(i), index2 = p2.get(j);
			if (index1 < index2) {
				min = Math.min(min, index2 - index1);
				i++;
			} else {
				min = Math.min(min, index1 - index2);
				j++;
			}
		}
		return min;
	}
}

// Your ShortestWordDistanceII object will be instantiated and called as such:
// ShortestWordDistanceII wordDistance = new ShortestWordDistanceII(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");