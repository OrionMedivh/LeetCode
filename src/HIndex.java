import java.util.Arrays;

public class HIndex {
  public int hIndex(int[] citations) {
    int n = citations.length;
    int[] buckets = new int[n+1];
    for(int c : citations) {
        if(c >= n) {
            buckets[n]++;
        } else {
            buckets[c]++;
        }
    }
    int count = 0;
    for(int i = n; i >= 0; i--) {
        count += buckets[i];
        if(count >= i) {
            return i;
        }
        // count of papers have at least i citations each, and the rest have no more than i citations
        // when store[i] >= i, we found what we're looking for.
    }
    return 0;
} // Bucket sort! O(N)

	  public int hIndex2(int[] citations) {
		if (citations == null || citations.length == 0)
			return 0;
		Arrays.sort(citations);
		int n = citations.length;
		// i here stands for number of papers ( from 0 to current)
		for (int i = 0; i < n; i++) {
			if (citations[i] >= n - i) //len-i of his/her N papers have at least len-i citations
				return n - i;
		}
		return 0;
	} //array sort is O(NlogN)
}