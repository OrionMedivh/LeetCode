
/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */

public class PopulatingNextRightPointersInEachNodeII {
	public void connect(TreeLinkNode root) {
		// create a dummy head of each down level
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
				root = dummyHead.next; // root -> start of next line
				dummyHead.next = null; // reset
				prev = dummyHead; // reset
			}
		}
	}

	// Without a dummy head, need to find a real head each time (not
	// recommended)
	public void connect2(TreeLinkNode root) {
		TreeLinkNode head = null;
		TreeLinkNode prev = null;
		while (root != null) {
			if (root.left != null) {
				if (prev != null) {
					prev.next = root.left;
				} else {
					head = root.left;
				}
				prev = root.left;
			}
			if (root.right != null) {
				if (prev != null) {
					prev.next = root.right;
				} else {
					head = root.right;
				}
				prev = root.right;
			}
			root = root.next;
			if (root == null) {
				root = head;
				head = null;
				prev = null;
			}
		}
	}
}
