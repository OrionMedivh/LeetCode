
public class BinarySearchStudy {

	public int BinarySearch(int[] haystack, int needle){
		return BinarySearchHelper(haystack, needle, 0, haystack.length-1);
	}
	
	public int BinarySearchHelper(int[] haystack, int needle, int start, int end){
		if(start == end) return haystack[start];
		int middle = (start + end)/2;
		if (needle <= haystack[middle]){
			return BinarySearchHelper(haystack, needle, start, middle);	
		}
		return BinarySearchHelper(haystack, needle, middle+1, end);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchStudy b = new BinarySearchStudy();
		System.out.println(b.BinarySearch(new int[]{1,2,4,5},3));
		System.out.println(b.BinarySearch(new int[]{1,2,3,4,5},4));
		System.out.println(b.BinarySearch(new int[]{1,2,4,5},2));
		System.out.println(b.BinarySearch(new int[]{1,2,4,5,6},3));
		System.out.println(b.BinarySearch(new int[]{1,2,3,4,6,7},5));
		System.out.println(b.BinarySearch(new int[]{1,2,3,4,6,7},8));

		//result showing either find the match, or the one number above.
		//except corner cases of start and end
	}

}
