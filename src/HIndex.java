
public class HIndex {
//	public int hIndex(int[] citations) {
//		if (citations == null || citations.length == 0)
//			return 0;
//		Arrays.sort(citations);
//		int n = citations.length;
//		for (int i = 0; i < n; i++) {
//			if (citations[i] >= n - i)
//				return n - i;
//		}
//		return 0;
//	} //array sort is O(NlogN)
	
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
	    }
	    return 0;
	} // Bucket sort! O(N)
}