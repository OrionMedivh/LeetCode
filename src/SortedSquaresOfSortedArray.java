
public class SortedSquaresOfSortedArray {
	public int[] sortedSquares(int[] nums) {
		int n = nums.length;
		int[] sorted = new int[n];
		int index = n - 1, i = 0, j = n - 1; // two pointers
		while (i <= j) {
			int square1 = nums[i] * nums[i];
			int square2 = nums[j] * nums[j];
			if (square1 >= square2) {
				sorted[index] = square1;
				i++;
			} else {
				sorted[index] = square2;
				j--;
			}
			index--;
		}
		return sorted;
	}
}
