
public class ConvertBinarySearchTreeToDoublyLinkedList {
	// We don't need to create DoublyListNode, we only modify
	// left->prev,right->next

	private TreeNode prev;

	public TreeNode BstToDoublyList(TreeNode root) {
		TreeNode head = new TreeNode(0);
		prev = head;
		helper(root);
		return head.right;
	}

	private void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		helper(root.left);
		root.left = prev;
		prev.right = root;
		prev = root;
		helper(root.right);
	}
}
