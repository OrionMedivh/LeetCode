
public class ListToTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return new TreeNode(head.val);
		ListNode end = head;
		while (end.next != null)
			end = end.next;
		return sortWithIndex(head, end);
	}

	public TreeNode sortWithIndex(ListNode head, ListNode end) {
		if (head == end)
			return new TreeNode(head.val);
		if (head.next == end) {
			TreeNode Node1 = new TreeNode(head.val);
			TreeNode Node2 = new TreeNode(end.val);
			Node2.left = Node1;
			return Node2;
		}
		ListNode slow = head;
		ListNode fast = head;
		ListNode last = slow;
		while (fast != end && fast.next != end) {
			last = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode middle = new TreeNode(slow.val);
		middle.left = sortWithIndex(head, last);
		middle.right = sortWithIndex(slow.next, end);
		return middle;
	}
}
