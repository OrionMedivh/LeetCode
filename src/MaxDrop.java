
public class MaxDrop {
	//maximum drop(must be dropped from left to right, no dups in array, only 1 peak or 1 valley, V or A shape)
	public int maxDrop(int[] a) {
		if (a == null || a.length < 2) {
			return 0;
		}
		int n = a.length;
		if (a[0] < a[1]) { // A shape 
			return findPeak(a, 0, n - 1, true) - a[n - 1];
		}
		else if(a[0] > a[1]){
			return a[0] - findPeak(a, 0, n-1, false);
		}
		return 0;
	}
	
	private int findPeak(int[] a, int start, int end, boolean direction){
		while(start < end){
			int mid = start + (end - start) /2; //prevent overflow
			if(a[mid] < a[mid+1] && direction){
				start = mid + 1;
			}else{
				end = mid;
			}
		}
		return a[start]; // start == end
	}
}
