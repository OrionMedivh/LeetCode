
public class IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
		int min = Integer.MAX_VALUE, secondmin = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num <= min) {
				min = num;
			} else if (num <= secondmin) {
				secondmin = num;
			} else {
				return true;
			}
		}
		return false;
	}
}
