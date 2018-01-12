import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClosestBinarySearchTreeValueII {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		Stack<TreeNode> left = new Stack<TreeNode>(), right = new Stack<TreeNode>();
		TreeNode node = root;
		while (node != null) {
			if (node.val >= target) {
				right.push(node);
				node = node.left;
			} else {
				left.push(node);
				node = node.right;
			}
		}

		while (k > 0) {
			TreeNode curNode;
			if (right.size() != 0 && (left.size() == 0 || (target - left.peek().val) >= (right.peek().val - target))) {// right
																														// is
																														// closer
				curNode = right.pop();
				list.add(curNode.val);
				k--;
				curNode = curNode.right;
				while (curNode != null) {
					right.push(curNode);
					curNode = curNode.left;
				}
			} else if (left.size() != 0
					&& (right.size() == 0 || (target - left.peek().val) < (right.peek().val - target))) {
				curNode = left.pop();
				list.add(curNode.val);
				k--;
				curNode = curNode.left;
				while (curNode != null) {
					left.push(curNode);
					curNode = curNode.right;
				}
			} else
				break;

		}
		return list;
	}
	
	//----------------------------------------------------------------------------------------
	
	/*
The idea is to compare the predecessors and successors of the closest node to the target, we can use two stacks to track the predecessors and successors, then like what we do in merge sort, we compare and pick the closest one to the target and put it to the result list.

As we know, inorder traversal gives us sorted predecessors, whereas reverse-inorder traversal gives us sorted successors.
	 */
	
	public List<Integer> closestKValues2(TreeNode root, double target, int k) {
		List<Integer> res = new ArrayList<>();

		Stack<Integer> s1 = new Stack<>(); // predecessors
		Stack<Integer> s2 = new Stack<>(); // successors

		inorder(root, target, false, s1);
		inorder(root, target, true, s2);

		while (k-- > 0) {
			if (s1.isEmpty())
				res.add(s2.pop());
			else if (s2.isEmpty())
				res.add(s1.pop());
			else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target))
				res.add(s1.pop());
			else
				res.add(s2.pop());
		}
		return res;
	}

	private void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {
		if (root == null) {
			return;
		}

		inorder(reverse ? root.right : root.left, target, reverse, stack);
		if ((reverse && root.val <= target) || (!reverse && root.val > target)) {
			return;
		}
		stack.push(root.val);
		inorder(reverse ? root.left : root.right, target, reverse, stack);
	}
	
//----------------------------------------------------------------------------------
	public static void main(String[] args) {
		ClosestBinarySearchTreeValueII s = new ClosestBinarySearchTreeValueII();
		TreeNode node1 = new TreeNode(7), node2 = new TreeNode(5), node3 = new TreeNode(3), node4 = new TreeNode(6),
				node5 = new TreeNode(9), node6 = new TreeNode(10);
		node1.left = node2;
		node1.right = node5;
		node2.left = node3;
		node2.right = node4;
		node6.left = node1;
		System.out.println(s.closestKValues(node4, 6.7, 2));
	}
}