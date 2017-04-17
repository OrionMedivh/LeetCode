import java.util.Arrays;

public class HIndex {
	public int hIndex(int[] citations) {
		// if( citations == null || citations.length == 0) return 0;
		// int n = citations.length;
		// int[] store= new int[n+1];
		// for(int i =0 ;i<n; i++){
		// if(citations[i] > n )
		// store[n]++;
		// else
		// store[citations[i]]++;
		// }
		//
		// for(int i = n; i>0; i--){
		// store[i-1]+=store[i];
		// if(store[i] >=i) return i; 
	  // // store[i] of papers have at least i citations each, and the rest have no more than i citations
	  // // when store[i] >= i, we found what we're looking for.
		// }
		// return 0;

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
	}
}