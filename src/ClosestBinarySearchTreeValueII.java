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