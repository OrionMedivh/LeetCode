import java.util.Arrays;

public class HIndex {
	public int hIndex(int[] citations) {
		// if( citations == null || citations.length == 0) return 0;
		// Arrays.sort(citations);
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
		// }
		// return 0;

		if (citations == null || citations.length == 0)
			return 0;
		Arrays.sort(citations);
		int n = citations.length;
		for (int i = 0; i < n; i++) {
			if (citations[i] >= n - i)
				return n - i;
		}
		return 0;
	}
}