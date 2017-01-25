
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

	public static int number;
	public static int n;

	public int kthSmallest(TreeNode root, int k) {
		n = k;
		InorderTraversal(root);
		return number;
	}

	public void InorderTraversal(TreeNode node) {
		if (node == null)
			return;
		InorderTraversal(node.left);
		if (--n == 0) {
			number = node.val;
			return;
		}
		InorderTraversal(node.right);
	}
}