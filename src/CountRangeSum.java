
public class CountRangeSum {
	public int countRangeSum(int[] nums, int lower, int upper) {
	    int n = nums.length;
	    long[] sums = new long[n + 1];
	    for (int i = 0; i < n; ++i)
	        sums[i + 1] = sums[i] + nums[i];
	    return countWhileMergeSort(sums, 0, n + 1, lower, upper);
	}

	private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
	    if (end - start <= 1) return 0;
	    int mid = (start + end) / 2;
	    int count = countWhileMergeSort(sums, start, mid, lower, upper) 
	              + countWhileMergeSort(sums, mid, end, lower, upper);
	    int upperIndex = mid, lowerIndex = mid, sumIndex = mid;
	    long[] cache = new long[end - start];
	    for (int i = start, cacheIndex = 0; i < mid; ++i, ++cacheIndex) {
	        while (lowerIndex < end && sums[lowerIndex] - sums[i] < lower) lowerIndex++;
	        while (upperIndex < end && sums[upperIndex] - sums[i] <= upper) upperIndex++;
	        while (sumIndex < end && sums[sumIndex] < sums[i]) cache[cacheIndex++] = sums[sumIndex++];
	        cache[cacheIndex] = sums[i];
	        count += upperIndex - lowerIndex;
	    }
	    System.arraycopy(cache, 0, sums, start, sumIndex - start);
	    return count;
	}
	
	public static void main(String[] args){
		CountRangeSum s = new CountRangeSum();
		System.out.println(s.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
	}
}
