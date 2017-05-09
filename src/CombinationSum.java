import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates.length == 0) {
			return res;
		}
		combinationSum(candidates, target, res, new ArrayList<>(), 0);
		return res;
	}

	private void combinationSum(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int start) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			list.add(candidates[i]);
			combinationSum(candidates, target - candidates[i], res, list, i);
			list.remove(list.size() - 1);
		}
	}
}
