import java.util.HashMap;
import java.util.Map;

/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	// With caching
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}

		TreeNode root = buildTree(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder, inMap);
		return root;
	}

	private TreeNode buildTree(int preStart, int preEnd, int inStart, int inEnd, int[] preorder, int[] inorder,
			Map<Integer, Integer> inMap) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = inMap.get(root.val);
		int numLeft = inIndex - inStart;
		// another way is to check if numLeft > 0, so that we can omit preEnd.

		// preorder splits into: preStart, [preStart + 1 ~ preStart + numLeft],
		// [preStart + numLeft + 1 ~ preEnd]
		// inorder splits into: [inStart ~ inIndex - 1], inIndex, [inIndex + 1 ~
		// inEnd]
		root.left = buildTree(preStart + 1, preStart + numLeft, inStart, inIndex - 1, preorder, inorder, inMap);
		root.right = buildTree(preStart + numLeft + 1, preEnd, inIndex + 1, inEnd, preorder, inorder, inMap);
		return root;
	}

	// ------------------------------------------------

	// Without caching
	public TreeNode buildTree2(int[] preorder, int[] inorder) {
		return helper(0, 0, inorder.length - 1, preorder, inorder);
	}

	private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		if (preStart > preorder.length - 1 || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = 0; // the index of the node in inorder
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == root.val) {
				inIndex = i;
			}
		}
		// Left:
		// preStart = preStart + 1;
		// inStart = inStart;
		// inEnd = inIndex - 1;
		root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
		// Right:
		// preStart = preStart + inIndex - inStart + 1
		// ( preStart + num of Nodes at left side + 1 )
		// inStart = inIndex + 1;
		// inEnd = inEnd;
		root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
		return root;
	}
}

/*
 * The basic idea is here: Say we have 2 arrays, PRE and IN. Preorder traversing
 * implies that PRE[0] is the root node. Then we can find this PRE[0] in IN, say
 * it's IN[5]. Now we know that IN[5] is root, so we know that IN[0] - IN[4] is
 * on the left side, IN[6] to the end is on the right side. Recursively doing
 * this on subarrays
 */
