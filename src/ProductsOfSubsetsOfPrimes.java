import java.util.ArrayList;
import java.util.List;

public class ProductsOfSubsetsOfPrimes {
	public List<Integer> subsets(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		helper(res, nums, 1, 0);
		return res;
	}

	private void helper(List<Integer> res, int[] nums, int product, int index) {
		if (product != 1) {
			res.add(product);
		}
		for (int i = index; i < nums.length; i++) {
			helper(res, nums, product * nums[i], i + 1);
		}
	}
}
