import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {
	// public ArrayList<Integer> inorderTraversal(TreeNode root) {
	// ArrayList<Integer> result=new ArrayList<Integer>();
	// if (root==null) return result;
	// ArrayList<Integer> left=inorderTraversal(root.left);
	// for (int i:left) result.add(i);
	// result.add(root.val);
	// ArrayList<Integer> right=inorderTraversal(root.right);
	// for (int i:right) result.add(i);
	// return result;
	// } //bad implementation

	// public List<Integer> inorderTraversal(TreeNode root) {
	// ArrayList<Integer> result = new ArrayList<Integer>();
	// inorder(root, result);
	// return result;
	// }
	//
	// public void inorder(TreeNode root, ArrayList<Integer> result){
	// if (root == null) return;
	// inorder(root.left, result);
	// result.add(root.val);
	// inorder(root.right, result);
	// } // much better and cleaner

	// public ArrayList<Integer> inorderTraversal(TreeNode root) {
	// ArrayList<Integer> result=new ArrayList<Integer>();
	// if (root==null) return result;
	// Stack<TreeNode> stack=new Stack<TreeNode>();
	// stack.push(root);
	// TreeNode nextNode=root;
	// while(!stack.isEmpty()){
	// while(nextNode.left!=null){
	// nextNode=nextNode.left;
	// stack.push(nextNode);
	// }
	// TreeNode curNode=stack.pop();
	// result.add(curNode.val);
	// if (curNode.right!=null) {
	// nextNode=curNode.right;
	// stack.push(nextNode);
	// }
	// }
	// return result;
	// }

	// refactory of the code above
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curNode = root;
		while (!stack.isEmpty() || curNode != null) {
			if (curNode != null) {// go through left branches
				stack.push(curNode);
				curNode = curNode.left;
			} else {// jump to the stack top
				curNode = stack.pop();
				result.add(curNode.val);
				curNode = curNode.right;
			}
		}
		return result;
	}
}