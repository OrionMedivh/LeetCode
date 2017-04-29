import java.util.ArrayList;
import java.util.Stack;

public class PathSumII {
	public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;
		Stack<TreeNode> nodestack = new Stack<TreeNode>();
		Stack<Integer> valuestack = new Stack<Integer>();
		Stack<ArrayList<Integer>> liststack = new Stack<ArrayList<Integer>>();
		nodestack.push(root);
		valuestack.push(root.val);
		ArrayList<Integer> init = new ArrayList<Integer>();
		init.add(root.val);
		liststack.push(init);
		while (!nodestack.isEmpty()) {
			TreeNode current = nodestack.pop();
			int value = valuestack.pop();
			ArrayList<Integer> list = liststack.pop();
			if (current.left != null) {
				nodestack.push(current.left);
				valuestack.push(value + current.left.val);
				ArrayList<Integer> newlist = new ArrayList<Integer>();
				for (int i : list)
					newlist.add(i);
				newlist.add(current.left.val);
				liststack.push(newlist);
			}
			if (current.right != null) {
				nodestack.push(current.right);
				valuestack.push(value + current.right.val);
				ArrayList<Integer> newlist = new ArrayList<Integer>();
				for (int i : list)
					newlist.add(i);
				newlist.add(current.right.val);
				liststack.push(newlist);
			}
			if (current.left == null && current.right == null) {
				if (sum == value) {
					result.add(list);
				}
			}
		}
		return result;
	}

	public static void main(String args[]) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(-2);
		TreeNode node3 = new TreeNode(3);
		node1.left = node2;
		node1.right = node3;
		System.out.println(pathSum(node1, 4));
	}
}