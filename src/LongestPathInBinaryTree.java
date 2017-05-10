
public class LongestPathInBinaryTree {
	private int max;

	// from any node to any node
	public int longestPath(TreeNode root) {
		max = Integer.MIN_VALUE;
		helper(root);
		return max;
	}

	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		max = Math.max(max, left + right + 1);
		return Math.max(left, right) + 1;
	}

	// from any leaf to any leaf
	public int longestPath2(TreeNode root) {
		max = Integer.MIN_VALUE;
		helper2(root);
		return max;
	}

	private int helper2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = helper2(root.left);
		int right = helper2(root.right);
		if (left != 0 && right != 0) {
			max = Math.max(max, left + right + 1);
		}
		return Math.max(left, right) + 1;
	}
}
