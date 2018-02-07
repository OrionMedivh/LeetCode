import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		levelOrder(root, list, 0);
		return list;
	}

	public void levelOrder(TreeNode node, List<List<Integer>> list, int level) {
		if (node == null) {
			return;
		}
		if (list.size() < level + 1) {
			list.add(new ArrayList<Integer>());
		}
		list.get(level).add(node.val);
		levelOrder(node.left, list, level + 1);
		levelOrder(node.right, list, level + 1);
	}

	public List<List<Integer>> levelOrderBFS(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		List<TreeNode> list = new ArrayList<>();
		list.add(root);
		List<Integer> res = new ArrayList<>();
		res.add(root.val);
		while (list.size() > 0) {
			result.add(res);
			List<TreeNode> nextList = new ArrayList<>();
			res = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				TreeNode node = list.get(i);
				if (node.left != null) {
					nextList.add(node.left);
					res.add(node.left.val);
				}
				if (node.right != null) {
					nextList.add(node.right);
					res.add(node.right.val);
				}
			}
			list = nextList;
		}
		return result;
	}
}
