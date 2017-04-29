import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {
	// public ArrayList<Integer> preorderTraversal(TreeNode root) {
	// ArrayList<Integer> result=new ArrayList<Integer>();
	// if (root==null) return result;
	// ArrayList<Integer> left=preorderTraversal(root.left);
	// ArrayList<Integer> right=preorderTraversal(root.right);
	// result.add(root.val);
	// for(int i:left) result.add(i);
	// for(int i:right) result.add(i);
	// return result;
	// } //passing value is tedious and very slow

	// public List<Integer> preorderTraversal(TreeNode root) {
	// ArrayList<Integer> result = new ArrayList<Integer>();
	// preorder(root, result);
	// return result;
	// }
	// public void preorder(TreeNode root, ArrayList<Integer> result){
	// if (root == null) return;
	// result.add(root.val);
	// preorder(root.left, result);
	// preorder(root.right, result);
	// } //passing as pointer is much faster and cleaner.

	// public ArrayList<Integer> preorderTraversal(TreeNode root) {
	// ArrayList<Integer> result=new ArrayList<Integer>();
	// if (root==null) return result;
	// Stack<TreeNode> stack=new Stack<TreeNode>();
	// stack.push(root);
	// result.add(root.val);
	// TreeNode curNode=root;
	// while(!stack.isEmpty()){
	// while (curNode.left!=null){
	// stack.push(curNode.left);
	// result.add(curNode.left.val);
	// curNode=curNode.left;
	// }
	// curNode=stack.pop();
	// if (curNode.right!=null){
	// curNode=curNode.right;
	// result.add(curNode.val);
	// stack.push(curNode);
	// }
	// }
	// return result;
	// }//bad implementation

	// modification and simplification of above
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curNode = root;
		while (!stack.isEmpty() || curNode != null) {// stop only when stack is
														// empty and no next
														// node exist.
			if (curNode != null) {// go through left branches.
				stack.push(curNode);
				result.add(curNode.val);
				curNode = curNode.left;
			} else {// jump to the stack top
				curNode = stack.pop();
				curNode = curNode.right;
			}
		}
		return result;
	}

	// public ArrayList<Integer> preorderTraversal(TreeNode root) {
	// ArrayList<Integer> result=new ArrayList<Integer>();
	// if (root==null) return result;
	// Stack<TreeNode> stack=new Stack<TreeNode>();
	// stack.push(root);
	// while(!stack.isEmpty()){
	// TreeNode cur=stack.pop();
	// result.add(cur.val);
	// if (cur.right!=null) stack.push(cur.right);
	// if (cur.left!=null) stack.push(cur.left);
	// }
	// return result;
	// } simple but not for general case.
}
