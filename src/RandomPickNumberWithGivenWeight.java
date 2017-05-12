import java.util.Random;

public class RandomPickNumberWithGivenWeight {

	// idea: use binary search to see which section the random number lands into

	public int randomNumber(int[] weights) {
		if (weights == null || weights.length == 0) {
			return 0;
		}
		int n = weights.length;
		for (int i = 1; i < n; i++) {
			weights[i] += weights[i - 1];
		}
		Random rand = new Random();
		int num = rand.nextInt(weights[n - 1]);
		return binarySearch(weights, 0, n - 1, num);
	}

	private int binarySearch(int[] weights, int start, int end, int target) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (target < weights[mid]) {
				end = mid;
			}
		}
	}
}
