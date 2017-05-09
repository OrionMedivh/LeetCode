import java.util.ArrayList;
import java.util.List;

public class AverageValueOfTreeLevel {
	public List<Integer> averageValueOfTreeLevel(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		List<List<Integer>> list = new ArrayList<>();
		LevelTraverse(root, list, 0);
		for (List<Integer> sublist : list) {
			int sum = 0;
			for (int i : sublist) {
				sum += i;
			}
			sum /= sublist.size();
			res.add(sum);
		}
		return res;
	}

	private void LevelTraverse(TreeNode node, List<List<Integer>> res, int level) {
		if (node == null) {
			return;
		}
		if (res.size() == level) {
			res.add(new ArrayList<Integer>());
		}
		res.get(level).add(node.val);
		LevelTraverse(node.left, res, level + 1);
		LevelTraverse(node.right, res, level + 1);
	}
}
