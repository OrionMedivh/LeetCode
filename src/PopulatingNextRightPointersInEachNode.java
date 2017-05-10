
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		if (root == null || root.left == null) {
			return;
		}
		root.left.next = root.right;
		if (root.right != null) {
			root.right.next = root.next.left;
		}
		connect(root.left);
		connect(root.right);
	}
}
