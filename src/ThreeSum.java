import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<>();
		int length = num.length;
		for (int i = 0; i < length - 2; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				int j = i + 1, k = length - 1;
				while (j < k) {
					int sum = num[i] + num[j] + num[k];
					if (sum == 0) {
						result.add(Arrays.asList(num[i], num[j], num[k]));
						while (j < k && num[j] == num[j + 1]) {
							j++;
						}
						while (j < k && num[k] == num[k - 1]) {
							k--;
						}
						j++;
						k--;
					} else if (sum < 0) {
						j++;
					} else {
						k--;
					}
				}
			}
		}
		return result;
	}
}
