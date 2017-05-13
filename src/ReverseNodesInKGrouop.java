
public class ReverseNodesInKGrouop {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode curr = head;
		int count = 0;
		while (curr != null && count < k) {
			curr = curr.next;
			count++;
		}
		if (count == k) {// if we have k nodes to reverse
			ListNode nextHead = reverseKGroup(curr, k);
			ListNode newHead = reverse(head, k);
			head.next = nextHead;
			head = newHead;
		}
		return head;
	}

	private ListNode reverse(ListNode head, int k) {
		ListNode prev = null;
		for (int i = 0; i < k; i++) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
}
