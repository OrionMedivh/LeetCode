
class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
		int closest = root.val;
		while (root != null) {
			if (Math.abs(closest - target) > Math.abs(root.val - target))
				closest = root.val;
			root = target >= root.val ? root.right : root.left;
		}
		return closest;
	}
} // iterative

class Solution2 {
	public int closestValue(TreeNode root, double target) {
		int a = root.val;
		TreeNode sub = target >= a ? root.right : root.left;
		if (sub == null)
			return a;
		int b = closestValue(sub, target);
		return Math.abs(a - target) < Math.abs(b - target) ? a : b;
	}
} // recursive