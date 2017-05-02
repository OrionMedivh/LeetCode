import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeVerticalOrder {
	private int min, max;

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		min = 0;
		max = 0;
		computeRange(root, 0);
		for (int i = min; i <= max; i++) {
			list.add(new ArrayList<>());
		}
		Queue<TreeNode> q = new LinkedList<>();
		Queue<Integer> index = new LinkedList<>();
		index.add(-min); // 0 -- |min| -- |min| + |max|
		// 0 ~ -min-1 || -min || -min+1 ~ -min+max
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			int i = index.poll();
			list.get(i).add(node.val);
			if (node.left != null) {
				q.add(node.left);
				index.add(i - 1);
			}
			if (node.right != null) {
				q.add(node.right);
				index.add(i + 1);
			}
		}
		return list;
	}

	private void computeRange(TreeNode root, int index) {
		if (root == null) {
			return;
		}
		min = Math.min(min, index);
		max = Math.max(max, index);
		computeRange(root.left, index - 1);
		computeRange(root.right, index + 1);
	}

	public List<List<Integer>> verticalOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		Queue<Integer> cols = new LinkedList<>();

		q.add(root);
		cols.add(0);

		int min = 0;
		int max = 0;

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			int col = cols.poll();

			if (!map.containsKey(col)) {
				map.put(col, new ArrayList<Integer>());
			}
			map.get(col).add(node.val);

			if (node.left != null) {
				q.add(node.left);
				cols.add(col - 1);
				min = Math.min(min, col - 1);
			}

			if (node.right != null) {
				q.add(node.right);
				cols.add(col + 1);
				max = Math.max(max, col + 1);
			}
		}

		for (int i = min; i <= max; i++) {
			res.add(map.get(i));
		}

		return res;
	}
}
