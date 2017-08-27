import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */

public class BinaryTreeLevelOrderTraversalII {

	public List<List<Integer>> levelOrderBottomDFS(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		levelOrderBottomDFS(root, 0, list);
		return list;
	}

	private void levelOrderBottomDFS(TreeNode root, int level, List<List<Integer>> list) {
		if (root == null) {
			return;
		}
		if (list.size() < level + 1) {
			list.add(0, new ArrayList<Integer>());
		}
		levelOrderBottomDFS(root.left, level + 1, list);
		list.get(list.size() - level - 1).add(root.val);
		levelOrderBottomDFS(root.right, level + 1, list);
	}

	// -----------------------------------------------------------------------------------

	public ArrayList<ArrayList<Integer>> levelOrderBottomRecursiveBFS(TreeNode root) {
		ArrayList<ArrayList<Integer>> listlist = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return listlist;
		Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
		Queue<TreeNode> current;
		Queue<TreeNode> next = new LinkedList<TreeNode>();
		next.add(root);
		while (!next.isEmpty()) {
			current = next;
			next = new LinkedList<TreeNode>();
			ArrayList<Integer> list = new ArrayList<Integer>();
			while (!current.isEmpty()) {
				TreeNode node = current.poll();
				list.add(node.val);
				if (node.left != null)
					next.add(node.left);
				if (node.right != null)
					next.add(node.right);
			}
			stack.add(list);
		}
		while (!stack.isEmpty())
			listlist.add(stack.pop());
		return listlist;
	}
}
