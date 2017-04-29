import java.util.ArrayList;
import java.util.Stack;

public class PostorderTraversal {
	// public ArrayList<Integer> postorderTraversal(TreeNode root) {
	// ArrayList<Integer> result=new ArrayList<Integer>();
	// if (root==null) return result;
	// ArrayList<Integer> left=postorderTraversal(root.left);
	// for (int i=0;i<left.size();i++){
	// result.add(left.get(i));
	// }
	// ArrayList<Integer> right=postorderTraversal(root.right);
	// for (int i=0;i<right.size();i++){
	// result.add(right.get(i));
	// }
	// result.add(root.val);
	// return result;
	// }

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Integer> s = new Stack<Integer>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode curNode = stack.pop();
			s.push(curNode.val);
			if (curNode.left != null)
				stack.push(curNode.left);
			if (curNode.right != null)
				stack.push(curNode.right);
		}
		while (!s.isEmpty())
			result.add(s.pop());
		return result;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		node1.right = node2;

		PostorderTraversal sol = new PostorderTraversal();
		ArrayList result = sol.postorderTraversal(node1);
	}
}