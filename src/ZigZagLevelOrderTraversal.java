import java.util.ArrayList;
import java.util.List;

public class ZigZagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		levelOrder(list, root, 0);
		return list;
	}

	private void levelOrder(List<List<Integer>> list, TreeNode node, int level) {
		if (node == null)
			return;
		if (list.size() < level + 1)
			list.add(new ArrayList<Integer>());
		if (level % 2 == 1)
			list.get(level).add(0, node.val);
		else
			list.get(level).add(node.val);
		levelOrder(list, node.left, level + 1);
		levelOrder(list, node.right, level + 1);
	}
}