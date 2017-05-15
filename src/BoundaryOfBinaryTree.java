import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/boundary-of-binary-tree/#/description

public class BoundaryOfBinaryTree {
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		result.add(root.val);
		getLeftBoundary(root.left, result);
		getLeaves(root.left, result);
		getLeaves(root.right, result);
		getRightBoundary(root.right, result);
		return result;
	}

	private void getLeaves(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			result.add(root.val);
			return;
		}
		getLeaves(root.left, result);
		getLeaves(root.right, result);
	}

	private void getLeftBoundary(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			return;
		}
		result.add(root.val);
		if (root.left == null) {
			getLeftBoundary(root.right, result);
		} else {
			getLeftBoundary(root.left, result);
		}
	}

	private void getRightBoundary(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			return;
		}
		if (root.right == null) {
			getRightBoundary(root.left, result);
		} else {
			getRightBoundary(root.right, result);
		}
		result.add(root.val);
	}
}
