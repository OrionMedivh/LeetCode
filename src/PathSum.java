
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		return hasPathSum(root, sum, 0);
	}

	public boolean hasPathSum(TreeNode node, int sum, int value) {
		if (node == null)
			return false;
		if (node.left != null || node.right != null)
			return hasPathSum(node.left, sum, value + node.val) || hasPathSum(node.right, sum, value + node.val);

		return sum == value + node.val;// node.left==null && node.right==null
	}
}
