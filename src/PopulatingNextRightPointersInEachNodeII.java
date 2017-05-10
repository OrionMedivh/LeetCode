
public class PopulatingNextRightPointersInEachNodeII {
	public void connect(TreeLinkNode root) {
		TreeLinkNode dummyHead = new TreeLinkNode(0);
		TreeLinkNode prev = dummyHead;
		while (root != null) {
			if (root.left != null) {
				prev.next = root.left; // connect prev->left
				prev = prev.next;
			}
			if (root.right != null) {
				prev.next = root.right;// connect prev->right
				prev = prev.next;
			}
			root = root.next; // root move to it's next
			if (root == null) { // time to go down
				prev = dummyHead; // put prev back to original place
				root = dummyHead.next; // root -> start of next line
				dummyHead.next = null; // reset two pointers
			}
		}
	}
}
