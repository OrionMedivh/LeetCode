
public class KthSmallestElementInBST {
	// public int kthSmallest(TreeNode root, int k) {
	// Stack<Integer> s = new Stack<Integer>();
	// InorderTraversal(root, k, s);
	// return s.peek();
	// }
	//
	// public void InorderTraversal(TreeNode node, int k, Stack<Integer> s){
	// if (s.size() == k) return;
	// if (node == null) return;
	// InorderTraversal(node.left, k, s);
	// if (s.size() == k) return;
	// s.push(node.val);
	// if (s.size() == k) return;
	// InorderTraversal(node.right, k, s);
	// if (s.size() == k) return;
	// }

	private int count;
	private int result;

	public int kthSmallest(TreeNode root, int k) {
		count = k;
		inorderTraversal(root);
		return result;
	}

	private void inorderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		inorderTraversal(node.left);
		count--;
		if (count == 0) {
			result = node.val;
			return;
		}
		inorderTraversal(node.right);
	}
}